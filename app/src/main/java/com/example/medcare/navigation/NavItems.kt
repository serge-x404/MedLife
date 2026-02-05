package com.example.medcare.navigation

import com.example.medcare.R

sealed class NavItems(val path: String, val label: String, val icon: Int, val selectedIcon: Int) {
    object Home: NavItems(NavRoute.Main.path, "Home", R.drawable.home_not_filled, R.drawable.home)
    object Services: NavItems(NavRoute.Services.path, "Services", R.drawable.services, R.drawable.services_filled)
    object History: NavItems(NavRoute.History.path, "History", R.drawable.history, R.drawable.history_filled)
    object Profile: NavItems(NavRoute.Profile.path, "Profile", R.drawable.profile, R.drawable.profile_filled)
}