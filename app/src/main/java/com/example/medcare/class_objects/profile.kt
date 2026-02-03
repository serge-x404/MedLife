package com.example.medcare.class_objects

import com.example.medcare.R

data class Notifications(
    val image: Int,
    val header: String,
    val body: String
)

object notification {
    val data = listOf(
        Notifications(R.drawable.alert_blue,
            "Doctor Appointment Reminder",
            "Hi [User's Name], this is a reminder for your consultation appointment with Dr. [Doctor's Name] tomorrow at 10:00 AM. " +
                    "Please make sure you arrive on time"
        ),
        Notifications(R.drawable.alert_purple,
            "New Medical Record Notification",
            "Hello [User's Name], you have a new medical record added to your profile. " +
                    "Please check for the latest information about your health condition."
        ),
        Notifications(R.drawable.alert_raise,
            "Medication Pickup Reminder",
            "Good morning [User's Name], don't forget to pick up your daily dose of medication, Paracetamol 500mg, today. " +
                    "Make sure you take it as directed by your doctor."
        )
    )
}