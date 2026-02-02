package com.example.medcare.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.medcare.homeScreen.HomeScreen
import com.example.medcare.splashScreen.splashscreen

@Composable
fun NavGraph(navHostController: NavHostController) {
    NavHost(navHostController, startDestination = NavRoute.Splash.path) {
        addHomeScreen(navHostController, this)
        addSplashScreen(navHostController, this)
    }
}

fun addHomeScreen(navHostController: NavHostController, navGraphBuilder: NavGraphBuilder)  {
    navGraphBuilder.composable(
        route = NavRoute.Main.path
    ) {
        HomeScreen()
    }
}
fun addSplashScreen(navHostController: NavHostController, navGraphBuilder: NavGraphBuilder) {
    navGraphBuilder.composable(
        route = NavRoute.Splash.path
    ) {
        splashscreen(
            navigateToHome = {
                navHostController.navigate(NavRoute.Main.path)
            }
        )
    }
}