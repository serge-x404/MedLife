package com.example.medcare.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.medcare.healthShop.Home.ShoppingHomePage
import com.example.medcare.healthShop.HotSalesGrid
import com.example.medcare.healthShop.MedicineDescription
import com.example.medcare.healthShop.MedicineGrid
import com.example.medcare.healthShop.cart.Cart
import com.example.medcare.history.HistoryScreen
import com.example.medcare.homeScreen.HomeScreen
import com.example.medcare.profile.NotificationScreen
import com.example.medcare.profile.ProfileScreen
import com.example.medcare.servicesScreen.ServicesScreen
import com.example.medcare.servicesScreen.chatDoc.ChatDoctorScreen
import com.example.medcare.splashScreen.AuthSplashScreen
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
        addAuthSplash(navHostController,this)
        addChatDocScreen(navHostController,this)
        addNotificationsScreen(navHostController,this)
        addCartScreen(navHostController,this)
        addHealthShop(navHostController,this)
        addMedGrid(navHostController,this)
        addMedDesc(navHostController,this)
    }
}

fun addHomeScreen(navHostController: NavHostController, navGraphBuilder: NavGraphBuilder)  {
    navGraphBuilder.composable(
        route = NavRoute.Main.path
    ) {
        HomeScreen(
            navigateToChatDoc = {
                navHostController.navigate(NavRoute.ChatDoc.path)
            },
            navigateToProfile = {
                navHostController.navigate(NavRoute.Profile.path) {
                    popUpTo(NavRoute.Main.path) {
                        inclusive = true
                    }
                }
            },
            navigateToNotifications = {
                navHostController.navigate(NavRoute.Notifications.path)
            },
            navigateToCart = {
                navHostController.navigate(NavRoute.Cart.path)
            },
            navigateToHealthShop = {
                navHostController.navigate(NavRoute.HealthShop.path)
            }
        )
    }
}
fun addSplashScreen(navHostController: NavHostController, navGraphBuilder: NavGraphBuilder) {
    navGraphBuilder.composable(
        route = NavRoute.Splash.path
    ) {
        splashscreen(
            navigateToOnBoard = {
                navHostController.navigate(NavRoute.Walkthrough.path)
            },
            navigateToHome = {
                navHostController.navigate(NavRoute.Main.path)
            }
        )
    }
}

fun addWalkthroughScreen(navHostController: NavHostController, navGraphBuilder: NavGraphBuilder) {
    navGraphBuilder.composable(
        route = NavRoute.Walkthrough.path
    ) {
        hPager(navigateToAuthSplash = {
            navHostController.navigate(NavRoute.AuthSplash.path)
        })
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
        ServicesScreen(
            navigateToChatDoc = {
                navHostController.navigate(NavRoute.ChatDoc.path)
            }
        )
    }
}

fun addHistoryScreen(navHostController: NavHostController, navGraphBuilder: NavGraphBuilder) {
    navGraphBuilder.composable(
        route = NavRoute.History.path
    ) {
        HistoryScreen()
    }
}

fun addAuthSplash(navHostController: NavHostController, navGraphBuilder: NavGraphBuilder) {
    navGraphBuilder.composable(
        route = NavRoute.AuthSplash.path
    ) {
        AuthSplashScreen()
    }
}

fun addChatDocScreen(navHostController: NavHostController, navGraphBuilder: NavGraphBuilder) {
    navGraphBuilder.composable(
        route = NavRoute.ChatDoc.path
    ) {
        ChatDoctorScreen()
    }
}

fun addNotificationsScreen(navHostController: NavHostController, navGraphBuilder: NavGraphBuilder) {
    navGraphBuilder.composable(
        route = NavRoute.Notifications.path
    ) {
        NotificationScreen()
    }
}

fun addCartScreen(navHostController: NavHostController, navGraphBuilder: NavGraphBuilder) {
    navGraphBuilder.composable(
        route = NavRoute.Cart.path
    ) {
        Cart()
    }
}

fun addHealthShop(navHostController: NavHostController, navGraphBuilder: NavGraphBuilder) {
    navGraphBuilder.composable(
        route = NavRoute.HealthShop.path
    ) {
        ShoppingHomePage(
            navigateToMedGrid = {
                navHostController.navigate(NavRoute.medGrid.path)
            },
            navigateToMedDesc = {
                navHostController.navigate(NavRoute.medDesc.path)
            }
        )
    }
}

fun addMedGrid(navHostController: NavHostController, navGraphBuilder: NavGraphBuilder) {
    navGraphBuilder.composable(
        route = NavRoute.medGrid.path
    ) {
        MedicineGrid(
            navigateToMedDesc = {
                navHostController.navigate(NavRoute.medDesc.path)
            }
        )
    }
}

fun addMedDesc(navHostController: NavHostController, navGraphBuilder: NavGraphBuilder) {
    navGraphBuilder.composable(
        route = NavRoute.medDesc.path
    ) {
        MedicineDescription()
    }
}