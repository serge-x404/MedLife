package com.example.medcare.screens.splashScreen

import com.example.medcare.R

object OnBoardContent {
    val pages = listOf(
        _root_ide_package_.com.example.medcare.screens.splashScreen.OnBoardingPage(
            "Online Consultation",
            "Connect with healthcare professionals virtually for convenient medical advice and support.",
            R.drawable.online_consultation_1
        ),
        _root_ide_package_.com.example.medcare.screens.splashScreen.OnBoardingPage(
            "24 Hours Ready to Serve",
            "Instant access to expert medical assistance. Get the care you need, when you need it, with our app.",
            R.drawable.twenty4hrs
        ),
        _root_ide_package_.com.example.medcare.screens.splashScreen.OnBoardingPage(
            "Medical Record Data Patient",
            " Easily manage and access comprehensive health records, including medical history, test results, and treatment plans, all in one secure place.",
            R.drawable.medical_report
        )
    )
}

data class OnBoardingPage(var title: String, var description: String, var image: Int)
