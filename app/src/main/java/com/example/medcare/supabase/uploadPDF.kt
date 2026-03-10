package com.example.medcare.supabase

import android.content.Context
import android.net.Uri
import io.github.jan.supabase.storage.storage

suspend fun uploadDocument(
    uri: Uri,
    context: Context,
    uid: String,
    onSuccess: (String) -> Unit,
    onFailure: (String) -> Unit
) {
    try {
        val readBytes = context.contentResolver.openInputStream(uri)?.readBytes() ?: return
        val fileName = "$uid/${System.currentTimeMillis()}.pdf"

        val url = supabase.storage.from("doctorDocuments").publicUrl(fileName)
        onSuccess(url)
    }
    catch (e: Exception) {
        onFailure(e.message ?: "Upload failed")
    }
}