package com.example.medcare

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.navigation.compose.rememberNavController
import com.example.medcare.navigation.NavGraph
import com.example.medcare.ui.theme.MedcareTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MedcareTheme {
                val navController = rememberNavController()

                NavGraph(navController)
            }
        }
    }
}
