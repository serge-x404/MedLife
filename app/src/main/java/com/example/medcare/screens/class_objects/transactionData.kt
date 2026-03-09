package com.example.medcare.screens.class_objects

data class TransactionHelper(
    val tName: String,
    val tAmt: String,
    val aChipData: String,
    val date: String,
    val day: String
)

object Transaction {
    val data = listOf(
        _root_ide_package_.com.example.medcare.screens.class_objects.TransactionHelper(
            "GP Consultation with Dr. Emily Smith",
            "$20.00",
            "Paid",
            "12",
            "Fri"
        ),
        _root_ide_package_.com.example.medcare.screens.class_objects.TransactionHelper(
            "GP Consultation with Dr. Emily Smith",
            "$20.00",
            "Paid",
            "18",
            "Thu"
        ),
        _root_ide_package_.com.example.medcare.screens.class_objects.TransactionHelper(
            "GP Consultation with Dr. Emily Smith",
            "$20.00",
            "Paid",
            "26",
            "Fri"
        ),
    )
}