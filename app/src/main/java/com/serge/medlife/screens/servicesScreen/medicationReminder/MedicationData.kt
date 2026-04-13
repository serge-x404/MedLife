package com.serge.medlife.screens.servicesScreen.medicationReminder

data class MedicationData(
    var key: String = "",
    var medName: String = "",
    var dosage: String = "",
    var timePeriod: String = "",
    var timesPerDay: String = "",
    var medStartDate: String = "",
    var medDuration: String = "",
    var medNotes: String = "",
    var medNotifications: Boolean = false,
    var expiryTimestamp: Long = 0L
)
