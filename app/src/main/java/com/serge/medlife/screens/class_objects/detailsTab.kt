package com.serge.medlife.screens.class_objects

import com.serge.medlife.R

object DocWorkHrs {
    val workingHours = listOf("9:00","10:00", "13:00", "14:00", "15:00", "16:00")
}


data class ReviewContents(
    val image: Int,
    val name: String,
    val timePeriod: String,
    val body: String
)

object Review {
    val reviews = listOf(
        ReviewContents(
            R.drawable.sofia,
            "Emily Johnson",
            "1 day ago",
            "My consultation with Dr. Luca Rossi was excellent. He's knowledgeable, attentive, and provided"
        ),
        ReviewContents(
            R.drawable.john,
            "Daniel Mark",
            "8 days ago",
            "My consultation with Dr. Luca Rossi was excellent. He's knowledgeable, attentive, and provided"
        )
    )
}