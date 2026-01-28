package com.example.medcare.splashScreen


sealed class NavRoute(val path: String) {
    object Splash : NavRoute("splash")
    object AuthSplash : NavRoute("authSplash")
    object Register : NavRoute("register_screen")
    object Login : NavRoute("login")
    object OTP : NavRoute("otp")
    object Verification : NavRoute("verification")
    object Main : NavRoute("main")
    object OnBoard : NavRoute("onBoard")
}

