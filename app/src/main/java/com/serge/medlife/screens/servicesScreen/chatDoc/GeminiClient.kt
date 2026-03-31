package com.serge.medlife.screens.servicesScreen.chatDoc

import android.util.Log
import com.google.firebase.Firebase
import com.google.firebase.ai.ai
import com.google.firebase.ai.type.GenerativeBackend
import com.google.firebase.ai.type.content
import com.google.firebase.ai.type.generationConfig

object GeminiClient {
    private val model = Firebase.ai(backend = GenerativeBackend.googleAI())
        .generativeModel(
            modelName = "gemini-3-flash-preview",
            generationConfig = generationConfig {
                temperature = 0.7f
            },
            systemInstruction = content {
                text("You are a helpful medical assistant for the application.")
            }
        )

    val chat = model.startChat()

    suspend fun sendMessage(message: String): String {
        return try {
            val response = chat.sendMessage(message)
            Log.d("Gemini","Response: ${response.text}")
            response.text ?: "No response"
        }
        catch (e: Exception) {
            Log.e("Gemini","Error: ${e.message}")
            "Error ${e.message}"
        }
    }
}