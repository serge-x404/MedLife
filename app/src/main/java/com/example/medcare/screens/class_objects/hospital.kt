package com.example.medcare.screens.class_objects

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
        _root_ide_package_.com.example.medcare.screens.class_objects.ListHospital(
            R.drawable.rafelle,
            "Ospedale San Raffaele",
            "Via Olgettina, 60, 20132 Milano MI, Italy",
            "(+22) 2361 6257 1726"
        ),
        _root_ide_package_.com.example.medcare.screens.class_objects.ListHospital(
            R.drawable.san_rafelle,
            "Ospedale San Raffaele",
            "Via Olgettina, 60, 20132 Milano MI, Italy",
            "(+22) 2361 6257 1726"
        ),
        _root_ide_package_.com.example.medcare.screens.class_objects.ListHospital(
            R.drawable.orthopedico,
            "IRCCS Istituto Ortopedico Galeazzi",
            "Via Riccardo Galeazzi, 4, 20161 Milano MI, Italy",
            "(+22) 2361 6257 1726"
        ),
        _root_ide_package_.com.example.medcare.screens.class_objects.ListHospital(
            R.drawable.rafelle,
            "Ospedale San Raffaele",
            "Via Olgettina, 60, 20132 Milano MI, Italy",
            "(+22) 2361 6257 1726"
        ),
    )

    val specialities = listOf(
        _root_ide_package_.com.example.medcare.screens.class_objects.Specialities(
            R.drawable.general,
            "General Practitioner"
        ),
        _root_ide_package_.com.example.medcare.screens.class_objects.Specialities(
            R.drawable.dentist,
            "Dentistry"
        ),
        _root_ide_package_.com.example.medcare.screens.class_objects.Specialities(
            R.drawable.gyanec,
            "Gynecology"
        ),
        _root_ide_package_.com.example.medcare.screens.class_objects.Specialities(
            R.drawable.eye,
            "Ophthalmology"
        ),
        _root_ide_package_.com.example.medcare.screens.class_objects.Specialities(
            R.drawable.neuro,
            "Neurology"
        ),
        _root_ide_package_.com.example.medcare.screens.class_objects.Specialities(
            R.drawable.ear,
            "Otorhinolaryngology"
        ),
        _root_ide_package_.com.example.medcare.screens.class_objects.Specialities(
            R.drawable.heart,
            "Psychiatrist"
        ),
    )

    val rooms = listOf(
        _root_ide_package_.com.example.medcare.screens.class_objects.Rooms(
            "General Ward",
            "120",
            "10",
            "$100 - $150"
        ),
        _root_ide_package_.com.example.medcare.screens.class_objects.Rooms(
            "Semi-Private Rooms",
            "80",
            "30",
            "$170 - $210"
        ),
        _root_ide_package_.com.example.medcare.screens.class_objects.Rooms(
            "Private Rooms",
            "40",
            "20",
            "$350 - $450"
        ),
        _root_ide_package_.com.example.medcare.screens.class_objects.Rooms(
            "Deluxe Suites",
            "12",
            "0",
            "$600 - $1000"
        ),
    )
}