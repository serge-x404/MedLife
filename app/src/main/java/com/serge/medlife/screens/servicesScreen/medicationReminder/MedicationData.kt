package com.serge.medlife.screens.servicesScreen.medicationReminder

data class MedicationData(
    val medName: String = "",
    val dosage: String = "",
    val timePeriod: String = "",
    val timesPerDay: String = "",
    val medStartDate: String = "",
    val medDuration: String = "",
    val medNotes: String = "",
    val medNotifications: Boolean = false
)
