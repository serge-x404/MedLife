package com.example.medcare.class_objects

import com.example.medcare.R

object docWorkHrs {
    val workingHours = listOf<String>("9:00 AM","10:00 AM", "1:00 PM", "2:00 PM", "3:00 PM", "4:00 PM")
}

object dates {
    val dates = listOf(
        DateDay("Wed","22"),
        DateDay("Thu","23"),
        DateDay("Fri","24"),
        DateDay("Sat","25"),
        DateDay("Sun","26"),
    )
}

data class DateDay(
    val day: String,
    val date: String
)

data class ReviewContents(
    val image: Int,
    val name: String,
    val timeperiod: String,
    val body: String
)

object review {
    val reviews = listOf(
        ReviewContents(R.drawable.sofia,"Emily Johnson","1 day ago","My consultation with Dr. Luca Rossi was excellent. He's knowledgeable, attentive, and provided"),
        ReviewContents(R.drawable.john,"Daniel Mark","8 days ago","My consultation with Dr. Luca Rossi was excellent. He's knowledgeable, attentive, and provided")
    )
}