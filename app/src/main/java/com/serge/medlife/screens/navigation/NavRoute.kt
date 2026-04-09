package com.serge.medlife.screens.navigation

import android.net.Uri

sealed class NavRoute(val path: String) {
    object Splash : NavRoute("splash")
    object AuthSplash : NavRoute("authSplash")
    object Register : NavRoute("register_screen")
    object Login : NavRoute("login")
    object Main : NavRoute("main")

    object DoctorMain: NavRoute("doctorMain")
    object Services : NavRoute("services")
    object ServicesNew: NavRoute("newServices")
    object Walkthrough: NavRoute("Walkthrough")
    object History: NavRoute("history")
    object Profile: NavRoute("profile")
    object ChatDoc: NavRoute("chatDoc?category={category}") {
        fun createRoute(category: String) = "chatDoc?category=${Uri.encode(category)}"
    }
    object Chat: NavRoute("chat")
    object DocDtls: NavRoute("docDtls?name={name}&specialization={specialization}&gender={gender}")
    object Appointment: NavRoute("appointment/{doctorName}/{doctorSpecialization}/{doctorGender}/{date}/{hours}")
    object AppointmentSuccess: NavRoute("AppointmentSuccess")
    object Notifications: NavRoute("notifications")
    object Cart: NavRoute("cart")
    object HealthShop: NavRoute("shop")
    object HospitalMap: NavRoute("googleMap")
    object AddMed: NavRoute("AddMed")
    object SavedReminder: NavRoute("SavedReminder")
    object ArticleHome: NavRoute("ArticleHome")
    object ArticleRead: NavRoute("ArticleRead")
    object ArticleGrid: NavRoute("ArticleGrid")
    object DoctorRegisterConfirmation: NavRoute("DoctorRegisterConfirmation")
}