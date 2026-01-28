package com.example.medcare.splashScreen

import com.example.medcare.R

object OnBoardContent {
    val pages = listOf(
        OnBoardingPage(
            "Online Consultation",
            "Connect with healthcare professionals virtually for convenient medical advice and support.",
            R.drawable.online_consultation_1
        ),
        OnBoardingPage(
            "24 Hours Ready to Serve",
            "Instant access to expert medical assistance. Get the care you need, when you need it, with our app.",
            R.drawable.twenty4hrs
        ),
        OnBoardingPage(
            "Medical Record Data Patient",
            " Easily manage and access comprehensive health records, including medical history, test results, and treatment plans, all in one secure place.",
            R.drawable.medical_report
        )
    )
}

data class OnBoardingPage(var title: String, var description: String, var image: Int)
