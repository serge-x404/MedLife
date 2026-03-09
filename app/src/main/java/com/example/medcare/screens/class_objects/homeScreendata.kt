package com.example.medcare.screens.class_objects

import com.example.medcare.R
import com.example.medcare.screens.navigation.NavRoute

object gridData {
    val servicesList = listOf(
        _root_ide_package_.com.example.medcare.screens.class_objects.Categories(
            "All",
            R.drawable.all
        ),
        _root_ide_package_.com.example.medcare.screens.class_objects.Categories(
            "General Practitioner",
            R.drawable.general
        ),
        _root_ide_package_.com.example.medcare.screens.class_objects.Categories(
            "Dentistry",
            R.drawable.dentist
        ),
        _root_ide_package_.com.example.medcare.screens.class_objects.Categories(
            "Gynecology",
            R.drawable.gyanec
        ),
        _root_ide_package_.com.example.medcare.screens.class_objects.Categories(
            "Ophthalmology",
            R.drawable.eye
        ),
        _root_ide_package_.com.example.medcare.screens.class_objects.Categories(
            "Neurology",
            R.drawable.neuro
        ),
        _root_ide_package_.com.example.medcare.screens.class_objects.Categories(
            "Otorhinolaryngology",
            R.drawable.ear
        ),
        _root_ide_package_.com.example.medcare.screens.class_objects.Categories(
            "Pulmonologist",
            R.drawable.lungs
        ),
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
        _root_ide_package_.com.example.medcare.screens.class_objects.Categories(
            "Chat Doctor",
            R.drawable.chat_services,
            _root_ide_package_.com.example.medcare.screens.navigation.NavRoute.ChatDoc.path
        ),
        _root_ide_package_.com.example.medcare.screens.class_objects.Categories(
            "Hospitals",
            R.drawable.hospital_new,
            _root_ide_package_.com.example.medcare.screens.navigation.NavRoute.hospital.path
        ),
        _root_ide_package_.com.example.medcare.screens.class_objects.Categories(
            "Emergency Calls",
            R.drawable.phone_call,
            null
        ),
        _root_ide_package_.com.example.medcare.screens.class_objects.Categories(
            "Article",
            R.drawable.article_new,
            _root_ide_package_.com.example.medcare.screens.navigation.NavRoute.articleHome.path
        ),
        _root_ide_package_.com.example.medcare.screens.class_objects.Categories(
            "Medication Reminder",
            R.drawable.pill,
            _root_ide_package_.com.example.medcare.screens.navigation.NavRoute.medReminder.path
        ),
        _root_ide_package_.com.example.medcare.screens.class_objects.Categories(
            "Specialization",
            R.drawable.stethoscope,
            _root_ide_package_.com.example.medcare.screens.navigation.NavRoute.specialist.path
        ),
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
        _root_ide_package_.com.example.medcare.screens.class_objects.Hospi(
            R.drawable.rscm,
            "Cipto Mangunkusumo Hospital (RSCM)"
        ),
        _root_ide_package_.com.example.medcare.screens.class_objects.Hospi(
            R.drawable.mitra,
            "Mitra Keluarga Hospital"
        ),
        _root_ide_package_.com.example.medcare.screens.class_objects.Hospi(
            R.drawable.rscm,
            "Cipto Mangunkusumo Hospital (RSCM)"
        ),
        _root_ide_package_.com.example.medcare.screens.class_objects.Hospi(
            R.drawable.mitra,
            "Mitra Keluarga Hospital"
        ),
        _root_ide_package_.com.example.medcare.screens.class_objects.Hospi(
            R.drawable.rscm,
            "Cipto Mangunkusumo Hospital (RSCM)"
        ),
    )
}