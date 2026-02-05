package com.example.medcare

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.medcare.navigation.BottomNavigation
import com.example.medcare.navigation.NavGraph
import com.example.medcare.navigation.NavRoute
import com.example.medcare.ui.theme.MedcareTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MedcareTheme {
                val navController = rememberNavController()

                val currentBackStack by navController.currentBackStackEntryAsState()

                val currentRoute = currentBackStack?.destination?.route

                val navItems =
                    listOf(
                        NavRoute.Main.path,
                        NavRoute.Services.path,
                        NavRoute.History.path,
                        NavRoute.Profile.path
                    )

                val showBottomBar = currentRoute in navItems

                Scaffold(
                    bottomBar = {
                        AnimatedVisibility(showBottomBar) {
                            BottomNavigation(navController)
                        }
                    }
                ) {

                    NavGraph(navController, Modifier.padding(it))
                }
            }
        }
    }
}
