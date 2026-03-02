package com.example.medcare.class_objects

import com.example.medcare.R
import com.example.medcare.navigation.NavRoute

object gridData {
    val servicesList = listOf(
        Categories("All", R.drawable.all),
        Categories("General Practitioner", R.drawable.general),
        Categories("Dentistry", R.drawable.dentist),
        Categories("Gynecology", R.drawable.gyanec),
        Categories("Ophthalmology", R.drawable.eye),
        Categories("Neurology", R.drawable.neuro),
        Categories("Otorhinolaryngology", R.drawable.ear),
        Categories("Pulmonologist", R.drawable.lungs),
    )
}

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
        Categories("Chat Doctor", R.drawable.chat_services, NavRoute.ChatDoc.path),
        Categories("Hospitals", R.drawable.hospital_new, NavRoute.hospital.path),
        Categories("Emergency Calls", R.drawable.phone_call, null),
        Categories("Article", R.drawable.article_new, NavRoute.articleHome.path),
        Categories("Medication Reminder", R.drawable.pill, NavRoute.medReminder.path),
        Categories("Specialization", R.drawable.stethoscope, NavRoute.specialist.path),
    )
}

object bestSellingProducts {
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
        Hospi(R.drawable.rscm,"Cipto Mangunkusumo Hospital (RSCM)"),
        Hospi(R.drawable.mitra,"Mitra Keluarga Hospital"),
        Hospi(R.drawable.rscm,"Cipto Mangunkusumo Hospital (RSCM)"),
        Hospi(R.drawable.mitra,"Mitra Keluarga Hospital"),
        Hospi(R.drawable.rscm,"Cipto Mangunkusumo Hospital (RSCM)"),
    )
}