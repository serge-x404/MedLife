package com.serge.medlife

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
import com.google.android.libraries.places.api.Places
import com.google.firebase.Firebase
import com.google.firebase.initialize
import com.serge.medlife.screens.navigation.BottomNavigation
import com.serge.medlife.screens.navigation.NavGraph
import com.serge.medlife.screens.navigation.NavRoute
import com.serge.medlife.theme.MedLifeTheme

class MainActivity : ComponentActivity() {

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        Firebase.initialize(this)

        Places.initializeWithNewPlacesApiEnabled(
            applicationContext,
            BuildConfig.MAPS_API_KEY
        )
        setContent {
            val sharedPreferences =
                applicationContext.getSharedPreferences("medLife", MODE_PRIVATE)
            MedLifeTheme {
                val navController = rememberNavController()

                val currentBackStack by navController.currentBackStackEntryAsState()

                val currentRoute = currentBackStack?.destination?.route

                val navItems =
                    listOf(
                        NavRoute.Main.path,
                        NavRoute.ServicesNew.path,
                        NavRoute.History.path,
                        NavRoute.Profile.path
                    )

                val showBottomBar = currentRoute in navItems

                Scaffold(
                    bottomBar = {
                        AnimatedVisibility(showBottomBar) {
                            BottomNavigation(
                                navController
                            )
                        }
                    }
                ) {

                    NavGraph(
                        navController, sharedPreferences,
                        Modifier.padding(it)
                    )
                }
            }
        }
    }
}
