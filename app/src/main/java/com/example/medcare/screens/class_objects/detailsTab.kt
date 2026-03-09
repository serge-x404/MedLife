package com.example.medcare.screens.class_objects

import com.example.medcare.R

object docWorkHrs {
    val workingHours = listOf<String>("9:00","10:00", "13:00", "14:00", "15:00", "16:00")
}

object dates {
    val dates = listOf(
        _root_ide_package_.com.example.medcare.screens.class_objects.DateDay("Wed", "22"),
        _root_ide_package_.com.example.medcare.screens.class_objects.DateDay("Thu", "23"),
        _root_ide_package_.com.example.medcare.screens.class_objects.DateDay("Fri", "24"),
        _root_ide_package_.com.example.medcare.screens.class_objects.DateDay("Sat", "25"),
        _root_ide_package_.com.example.medcare.screens.class_objects.DateDay("Sun", "26"),
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
        _root_ide_package_.com.example.medcare.screens.class_objects.ReviewContents(
            R.drawable.sofia,
            "Emily Johnson",
            "1 day ago",
            "My consultation with Dr. Luca Rossi was excellent. He's knowledgeable, attentive, and provided"
        ),
        _root_ide_package_.com.example.medcare.screens.class_objects.ReviewContents(
            R.drawable.john,
            "Daniel Mark",
            "8 days ago",
            "My consultation with Dr. Luca Rossi was excellent. He's knowledgeable, attentive, and provided"
        )
    )
}