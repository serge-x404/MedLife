package com.example.medcare.supabase

import android.content.Context
import android.net.Uri
import android.util.Log
import io.github.jan.supabase.storage.storage

suspend fun uploadDocument(
    uri: Uri,
    context: Context,
    uid: String,
    onSuccess: (String) -> Unit,
    onFailure: (String) -> Unit
) {
    try {
        val readBytes = context.contentResolver.openInputStream(uri)?.readBytes() ?: run {
            Log.e("Supabase", "Failed to read file bytes")
            return
        }
        Log.d("Supabase", "File size: ${readBytes.size} bytes")
        val fileName = "$uid/${System.currentTimeMillis()}.pdf"
        Log.d("Supabase", "Uploading file: $fileName")

        supabase.storage.from("doctorDocuments").upload(fileName, readBytes)
        Log.d("Supabase", "Upload successful")

        val url = supabase.storage.from("doctorDocuments").publicUrl(fileName)
        Log.d("Supabase", "Public URL: $url")
        onSuccess(url)
    }
    catch (e: Exception) {
        Log.e("Supabase", "Error: ${e.message}")
        onFailure(e.message ?: "Upload failed")
    }
}