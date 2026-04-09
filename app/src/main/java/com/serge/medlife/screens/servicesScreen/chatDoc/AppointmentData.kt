package com.serge.medlife.screens.servicesScreen.chatDoc

data class AppointmentData(
    val key: String = "",
    val userName: String = "",
    val doctorName: String = "",
    val selectedHour: String = "",
    val selectedDate: String = "",
    val appointmentStatus: String = "Waiting for confirmation"
)
