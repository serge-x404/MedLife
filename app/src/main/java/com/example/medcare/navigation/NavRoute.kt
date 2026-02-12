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
    object DocDtls: NavRoute("docDtls")
    object Notifications: NavRoute("notifications")
    object Cart: NavRoute("cart")
    object findingPharma: NavRoute("findPharma")
    object emptyCart: NavRoute("emptyCart")
    object HealthShop: NavRoute("shop")
    object medGrid: NavRoute("medGrid")
    object medDesc: NavRoute("medDesc")
    object hospital: NavRoute("hospital")
    object hospiDtls: NavRoute("hospiDtls")
    object hospiLayout: NavRoute("hospiLayout")
    object hospiMap: NavRoute("hospiMap")
    object medReminder: NavRoute("medReminder")
    object addMed: NavRoute("addMed")
    object savedReminder: NavRoute("savedReminder"){
//        val medName = "Paracetamol"
//        val dosage = "2"
//        val timings = "after meal"
    }
    object specialist: NavRoute("specialist")
    object articleHome: NavRoute("articleHome")
    object articleRead: NavRoute("articleRead")
    object articleGrid: NavRoute("articleGrid")
    object presHist: NavRoute("presHist")
    object healthHist: NavRoute("healthHist")
    object transactions: NavRoute("transactions")
    object accSett: NavRoute("accSett")
    object clearNoti: NavRoute("clearNoti")
    object pharmaPortal: NavRoute("pharmaPortal")
    object pharmaRegister: NavRoute("pharmaRegister")
}