package com.example.medcare.class_objects

import com.example.medcare.R

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
    val name: String, val icon: Int
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
        Categories("Chat Doctor", R.drawable.chat_doctor),
        Categories("Hospitals", R.drawable.hospital),
        Categories("Emergency Calls", R.drawable.emergency_calls),
        Categories("Article", R.drawable.article),
        Categories("Medication Reminder", R.drawable.reminder),
        Categories("Specialization", R.drawable.specialization),
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