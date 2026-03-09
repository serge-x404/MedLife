package com.example.medcare.screens.navigation

import com.example.medcare.R

sealed class NavItems(val path: String, val label: String, val icon: Int, val selectedIcon: Int) {
    object Home: com.example.medcare.screens.navigation.NavItems(_root_ide_package_.com.example.medcare.screens.navigation.NavRoute.Main.path, "Home", R.drawable.home_not_filled, R.drawable.home)
    object Services: com.example.medcare.screens.navigation.NavItems(_root_ide_package_.com.example.medcare.screens.navigation.NavRoute.Services.path, "Services", R.drawable.services, R.drawable.services_filled)
    object History: com.example.medcare.screens.navigation.NavItems(_root_ide_package_.com.example.medcare.screens.navigation.NavRoute.History.path, "History", R.drawable.history, R.drawable.history_filled)
    object Profile: com.example.medcare.screens.navigation.NavItems(_root_ide_package_.com.example.medcare.screens.navigation.NavRoute.Profile.path, "Profile", R.drawable.profile, R.drawable.profile_filled)
}