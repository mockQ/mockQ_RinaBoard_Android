package com.rinaboard.controller.data

import android.content.Context
import android.net.Uri
import android.provider.DocumentsContract

/**
 * 表情文件读取器。
 *
 * 推荐用法：
 * 1. 把 SD 卡中的 out 文件夹复制到手机任意可编辑位置，例如 Documents/RinaBoard/out。
 * 2. 在 APP 的“表情”页选择该 out 文件夹（也可以选择它的上一级 RinaBoard 文件夹）。
 * 3. APP 持久保存该目录访问权限；以后直接用手机文件管理器修改 fN.txt 即可，不需要重新打包 APK。
 *
 * 文件格式与 ESP32 SD 卡保持一致：out/f1.txt、out/f2.txt……
 */
data class FacePattern(
    val faceNo: Int,
    val fileName: String,
    val ledIds: Set<Int>
)

object FaceAssetRepository {
    private const val ASSET_DIR = "out"
    private val faceFileRegex = Regex("^f(\\d+)\\.txt$", RegexOption.IGNORE_CASE)
    private val numberRegex = Regex("\\d+")

    private data class DocEntry(
        val documentId: String,
        val displayName: String,
        val mimeType: String
    )

    /**
     * 优先读取用户在手机上选择的目录；如果尚未选择，则兼容读取 APK assets/out。
     */
    fun load(context: Context, treeUriString: String?): List<FacePattern> {
        if (!treeUriString.isNullOrBlank()) {
            val external = loadFromDocumentTree(context, treeUriString)
            if (external != null) return external
        }
        return loadFromAssets(context)
    }

    /** 返回当前已选择目录中真正使用的 out 文件夹名称。 */
    fun selectedFolderName(context: Context, treeUriString: String?): String? {
        if (treeUriString.isNullOrBlank()) return null
        val treeUri = runCatching { Uri.parse(treeUriString) }.getOrNull() ?: return null
        val rootId = runCatching { DocumentsContract.getTreeDocumentId(treeUri) }.getOrNull() ?: return null
        val root = queryDocument(context, treeUri, rootId) ?: return null
        if (root.displayName.equals("out", ignoreCase = true)) return root.displayName
        return listChildren(context, treeUri, rootId)
            .firstOrNull {
                it.mimeType == DocumentsContract.Document.MIME_TYPE_DIR &&
                        it.displayName.equals("out", ignoreCase = true)
            }?.displayName ?: root.displayName
    }

    /**
     * 从 Storage Access Framework 选中的目录读取表情。
     * 返回 null 表示 URI 已失效；返回空列表表示目录有效但没有 f数字.txt。
     */
    private fun loadFromDocumentTree(context: Context, treeUriString: String): List<FacePattern>? {
        val treeUri = runCatching { Uri.parse(treeUriString) }.getOrNull() ?: return null
        val rootId = runCatching { DocumentsContract.getTreeDocumentId(treeUri) }.getOrNull() ?: return null
        val root = queryDocument(context, treeUri, rootId) ?: return null

        // 可以直接选择 out，也可以选择包含 out 的上一级目录。
        val outId = if (root.displayName.equals("out", ignoreCase = true)) {
            rootId
        } else {
            listChildren(context, treeUri, rootId)
                .firstOrNull {
                    it.mimeType == DocumentsContract.Document.MIME_TYPE_DIR &&
                            it.displayName.equals("out", ignoreCase = true)
                }?.documentId ?: return emptyList()
        }

        return listChildren(context, treeUri, outId)
            .asSequence()
            .filter { it.mimeType != DocumentsContract.Document.MIME_TYPE_DIR }
            .mapNotNull { entry ->
                val match = faceFileRegex.matchEntire(entry.displayName) ?: return@mapNotNull null
                val faceNo = match.groupValues[1].toIntOrNull() ?: return@mapNotNull null
                if (faceNo <= 0) return@mapNotNull null

                val fileUri = DocumentsContract.buildDocumentUriUsingTree(treeUri, entry.documentId)
                val text = runCatching {
                    context.contentResolver.openInputStream(fileUri)
                        ?.bufferedReader(Charsets.UTF_8)
                        ?.use { it.readText() }
                }.getOrNull() ?: return@mapNotNull null

                FacePattern(
                    faceNo = faceNo,
                    fileName = entry.displayName,
                    ledIds = parseLedIds(text)
                )
            }
            .sortedBy { it.faceNo }
            .toList()
    }

    private fun queryDocument(context: Context, treeUri: Uri, documentId: String): DocEntry? {
        val uri = DocumentsContract.buildDocumentUriUsingTree(treeUri, documentId)
        val projection = arrayOf(
            DocumentsContract.Document.COLUMN_DOCUMENT_ID,
            DocumentsContract.Document.COLUMN_DISPLAY_NAME,
            DocumentsContract.Document.COLUMN_MIME_TYPE
        )
        return runCatching {
            context.contentResolver.query(uri, projection, null, null, null)?.use { cursor ->
                if (!cursor.moveToFirst()) return@use null
                DocEntry(
                    documentId = cursor.getString(0),
                    displayName = cursor.getString(1).orEmpty(),
                    mimeType = cursor.getString(2).orEmpty()
                )
            }
        }.getOrNull()
    }

    private fun listChildren(context: Context, treeUri: Uri, parentDocumentId: String): List<DocEntry> {
        val uri = DocumentsContract.buildChildDocumentsUriUsingTree(treeUri, parentDocumentId)
        val projection = arrayOf(
            DocumentsContract.Document.COLUMN_DOCUMENT_ID,
            DocumentsContract.Document.COLUMN_DISPLAY_NAME,
            DocumentsContract.Document.COLUMN_MIME_TYPE
        )
        return runCatching {
            buildList {
                context.contentResolver.query(uri, projection, null, null, null)?.use { cursor ->
                    while (cursor.moveToNext()) {
                        add(
                            DocEntry(
                                documentId = cursor.getString(0),
                                displayName = cursor.getString(1).orEmpty(),
                                mimeType = cursor.getString(2).orEmpty()
                            )
                        )
                    }
                }
            }
        }.getOrDefault(emptyList())
    }

    /** 兼容旧版本：未选择手机目录时仍可读取打包进 APK 的 assets/out。 */
    private fun loadFromAssets(context: Context): List<FacePattern> {
        val assets = context.assets
        val names = assets.list(ASSET_DIR).orEmpty()

        return names.mapNotNull { fileName ->
            val match = faceFileRegex.matchEntire(fileName) ?: return@mapNotNull null
            val faceNo = match.groupValues[1].toIntOrNull() ?: return@mapNotNull null
            if (faceNo <= 0) return@mapNotNull null

            val text = runCatching {
                assets.open("$ASSET_DIR/$fileName").bufferedReader(Charsets.UTF_8).use { it.readText() }
            }.getOrNull() ?: return@mapNotNull null

            FacePattern(
                faceNo = faceNo,
                fileName = fileName,
                ledIds = parseLedIds(text)
            )
        }.sortedBy { it.faceNo }
    }

    private fun parseLedIds(text: String): Set<Int> =
        numberRegex.findAll(text)
            .mapNotNull { it.value.toIntOrNull() }
            .filter { it in 0 until BoardProtocol.LED_COUNT }
            .toSet()
}
