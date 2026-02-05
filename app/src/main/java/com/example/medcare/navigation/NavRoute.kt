package com.example.medcare.navigation

sealed class NavRoute(val path: String) {
    object Splash : NavRoute("splash")
    object AuthSplash : NavRoute("authSplash")
    object Register : NavRoute("register_screen")
    object Login : NavRoute("login")
    object OTP : NavRoute("otp")
    object Verification : NavRoute("verification")
    object Main : NavRoute("main")
    object Services : NavRoute("services")
    object OnBoard : NavRoute("onBoard")
    object Walkthrough: NavRoute("walkthrough")
    object History: NavRoute("history")
    object Profile: NavRoute("profile")
    object ChatDoc: NavRoute("chatDoc")
    object Notifications: NavRoute("notifications")
    object Cart: NavRoute("cart")
    object HealthShop: NavRoute("shop")
    object medGrid: NavRoute("medGrid")
    object medDesc: NavRoute("medDesc")
}