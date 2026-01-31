package com.example.medcare.clobs

import com.example.medcare.R

data class ListHospital(
    val hospitalImage: Int,
    val hospitalName: String,
    val hospitalLocation: String,
    val hospitalNumber: String
)
data class Specialities(
    val image: Int,
    val name: String
)

data class Rooms(
    val roomName: String,
    val totalBeds: String,
    val availableBeds: String,
    val price: String
)
object HospitalData {
    val data = listOf(
        ListHospital(R.drawable.rafelle,
            "Ospedale San Raffaele",
            "Via Olgettina, 60, 20132 Milano MI, Italy",
            "(+22) 2361 6257 1726"),
        ListHospital(R.drawable.san_rafelle,
            "Ospedale San Raffaele",
            "Via Olgettina, 60, 20132 Milano MI, Italy",
            "(+22) 2361 6257 1726"),
        ListHospital(R.drawable.orthopedico,
            "IRCCS Istituto Ortopedico Galeazzi",
            "Via Riccardo Galeazzi, 4, 20161 Milano MI, Italy",
            "(+22) 2361 6257 1726"),
        ListHospital(R.drawable.rafelle,
            "Ospedale San Raffaele",
            "Via Olgettina, 60, 20132 Milano MI, Italy",
            "(+22) 2361 6257 1726"),
    )

    val specialities = listOf(
        Specialities(R.drawable.general,"General Practitioner"),
        Specialities(R.drawable.dentist,"Dentistry"),
        Specialities(R.drawable.gyanec,"Gynecology"),
        Specialities(R.drawable.eye,"Ophthalmology"),
        Specialities(R.drawable.neuro,"Neurology"),
        Specialities(R.drawable.ear,"Otorhinolaryngology"),
        Specialities(R.drawable.heart,"Psychiatrist"),
    )

    val rooms = listOf(
        Rooms("General Ward","120","10","$100 - $150"),
        Rooms("Semi-Private Rooms","80","30","$170 - $210"),
        Rooms("Private Rooms","40","20","$350 - $450"),
        Rooms("Deluxe Suites","12","0","$600 - $1000"),
    )
}