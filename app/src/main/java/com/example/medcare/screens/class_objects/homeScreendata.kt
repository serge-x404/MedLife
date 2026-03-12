package com.example.medcare.screens.class_objects

import com.example.medcare.R
import com.example.medcare.screens.navigation.NavRoute

data class Categories(
    val name: String, val icon: Int, val route: String? = null
)

object lazyRow {
    val doctors = listOf(
        R.drawable.heart_specialist,
        R.drawable.doctor_dentist,
        R.drawable.heart_specialist,
        R.drawable.doctor_dentist,
        R.drawable.heart_specialist,
        R.drawable.doctor_dentist,
        R.drawable.heart_specialist,
        R.drawable.doctor_dentist
    )
}

object serviceGridData {
    val serviceImages = listOf(
        Categories(
            "Article",
            R.drawable.article_new,
            NavRoute.articleHome.path
        ),
        Categories(
            "Consult Doctor",
            R.drawable.stethoscope,
            NavRoute.ChatDoc.path
        ),
        Categories(
            "Hospitals",
            R.drawable.hospital_new,
            NavRoute.hospital.path
        ),
//        Categories(
//            "Emergency Calls",
//            R.drawable.phone_call,
//            null
//        ),
        Categories(
            "Medication Reminder",
            R.drawable.pill,
            NavRoute.medReminder.path
        ),
//        Categories(
//            "Specialization",
//            R.drawable.stethoscope,
//            NavRoute.specialist.path
//        ),
    )
}

object BestSellingProducts {
    val data = listOf(
        R.drawable.vaccine_product,
        R.drawable.braces,
        R.drawable.wheelchair,
        R.drawable.mask
    )
}

data class Hospi(
    val img: Int,
    val name: String
)
object hospitals {
    val images = listOf(
        Hospi(
            R.drawable.rscm,
            "Cipto Mangunkusumo Hospital (RSCM)"
        ),
        Hospi(
            R.drawable.mitra,
            "Mitra Keluarga Hospital"
        ),
        Hospi(
            R.drawable.rscm,
            "Cipto Mangunkusumo Hospital (RSCM)"
        ),
        Hospi(
            R.drawable.mitra,
            "Mitra Keluarga Hospital"
        ),
        Hospi(
            R.drawable.rscm,
            "Cipto Mangunkusumo Hospital (RSCM)"
        ),
    )
}