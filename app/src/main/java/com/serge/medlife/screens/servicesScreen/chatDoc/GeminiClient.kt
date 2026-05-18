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
                temperature = 0.3f
            },
            systemInstruction = content {
                text("""
                You are MedBot, a professional medical assistant integrated into MedLife, 
                a healthcare management application. Your role is to:
                
                1. PROVIDE accurate, clear and concise medical information
                2. HELP users understand symptoms, medications, and general health conditions
                3. GUIDE users to book appointments with the right specialist based on their symptoms
                4. REMIND users that you are not a substitute for professional medical advice
                5. SUGGEST users to seek emergency help immediately for life-threatening conditions
                
                STRICT RULES:
                - Never diagnose a condition with certainty
                - Always recommend consulting a doctor for serious concerns
                - Keep responses brief, clear and easy to understand
                - Use simple language, avoid heavy medical jargon
                - If asked about emergency symptoms like chest pain, difficulty breathing or stroke, 
                  always direct the user to call emergency services immediately
                - Do not provide specific drug dosages or prescriptions
                - Do not discuss topics unrelated to health and medicine
                
                TONE:
                - Be empathetic, calm and professional
                - Be supportive and reassuring
                - Keep responses concise — no unnecessary long paragraphs
            """.trimIndent())
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