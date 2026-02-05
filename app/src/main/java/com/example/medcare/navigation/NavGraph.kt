package com.example.medcare.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.medcare.history.HistoryScreen
import com.example.medcare.homeScreen.HomeScreen
import com.example.medcare.profile.ProfileScreen
import com.example.medcare.servicesScreen.ServicesScreen
import com.example.medcare.splashScreen.hPager
import com.example.medcare.splashScreen.splashscreen
import com.example.medcare.splashScreen.walkthrough

@Composable
fun NavGraph(navHostController: NavHostController, modifier: Modifier) {
    NavHost(navHostController, startDestination = NavRoute.Splash.path) {
        addHomeScreen(navHostController, this)
        addSplashScreen(navHostController, this)
        addWalkthroughScreen(navHostController,this)
        addProfileScreen(navHostController,this)
        addHistoryScreen(navHostController,this)
        addServicesScreen(navHostController,this)
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
            },
            navigateToOnBoard = {
                navHostController.navigate(NavRoute.Walkthrough.path)
            }
        )
    }
}

fun addWalkthroughScreen(navHostController: NavHostController, navGraphBuilder: NavGraphBuilder) {
    navGraphBuilder.composable(
        route = NavRoute.Walkthrough.path
    ) {
        hPager(
            navigateToHome = {
                navHostController.navigate(NavRoute.Main.path)
            }
        )
    }
}

fun addProfileScreen(navHostController: NavHostController, navGraphBuilder: NavGraphBuilder) {
    navGraphBuilder.composable(
        route = NavRoute.Profile.path
    ) {
        ProfileScreen()
    }
}

fun addServicesScreen(navHostController: NavHostController, navGraphBuilder: NavGraphBuilder) {
    navGraphBuilder.composable(
        route = NavRoute.Services.path
    ) {
        ServicesScreen()
    }
}

fun addHistoryScreen(navHostController: NavHostController, navGraphBuilder: NavGraphBuilder) {
    navGraphBuilder.composable(
        route = NavRoute.History.path
    ) {
        HistoryScreen()
    }
}