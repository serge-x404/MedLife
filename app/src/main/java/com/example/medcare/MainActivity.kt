package com.example.medcare

import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.annotation.RequiresApi
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.medcare.screens.navigation.BottomNavigation
import com.example.medcare.screens.navigation.NavGraph
import com.example.medcare.screens.navigation.NavRoute
import com.example.medcare.ui.theme.MedlifeTheme
import com.google.firebase.Firebase
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.initialize

class MainActivity : ComponentActivity() {


    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        Firebase.initialize(this)
        val auth = FirebaseAuth.getInstance()
        setContent {
            val sharedPreferences =
                applicationContext.getSharedPreferences("medlife", MODE_PRIVATE)
            MedlifeTheme {
                val navController = rememberNavController()

                val currentBackStack by navController.currentBackStackEntryAsState()

                val currentRoute = currentBackStack?.destination?.route

                val navItems =
                    listOf(
                        _root_ide_package_.com.example.medcare.screens.navigation.NavRoute.Main.path,
                        _root_ide_package_.com.example.medcare.screens.navigation.NavRoute.Services.path,
                        _root_ide_package_.com.example.medcare.screens.navigation.NavRoute.History.path,
                        _root_ide_package_.com.example.medcare.screens.navigation.NavRoute.Profile.path
                    )

                val showBottomBar = currentRoute in navItems

                Scaffold(
                    bottomBar = {
                        AnimatedVisibility(showBottomBar) {
                            _root_ide_package_.com.example.medcare.screens.navigation.BottomNavigation(
                                navController
                            )
                        }
                    }
                ) {

                    _root_ide_package_.com.example.medcare.screens.navigation.NavGraph(
                        navController, sharedPreferences,
                        isLoggedIn = auth.currentUser != null,
                        isRegistered = auth.currentUser != null,
                        Modifier.padding(it)
                    )
                }
            }
        }
    }
}
