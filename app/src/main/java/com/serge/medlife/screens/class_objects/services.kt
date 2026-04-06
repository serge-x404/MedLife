package com.serge.medlife.screens.class_objects

import com.serge.medlife.R
import com.serge.medlife.screens.navigation.NavRoute

data class Categories(
    val name: String, val icon: Int, val route: String? = null
)

object ServiceGridData {
    val serviceImages = listOf(
        Categories(
            "Article",
            R.drawable.article_new,
            NavRoute.articleHome.path
        ),
        Categories(
            "Consult Doctor",
            R.drawable.stethoscope,
            NavRoute.ChatDoc.createRoute("All")
        ),
        Categories(
            "Hospitals",
            R.drawable.hospital_new,
            NavRoute.newHospitalMap.path
        ),
        Categories(
            "Medication Reminder",
            R.drawable.pill,
            NavRoute.savedReminder.path
        )
    )
}