package com.example.medcare.class_objects

data class TransactionHelper(
    val tName: String,
    val tAmt: String,
    val aChipData: String,
    val date: String,
    val day: String
)

object Transaction {
    val data = listOf(
        TransactionHelper("GP Consultation with Dr. Emily Smith","$20.00","Paid","12", "Fri"),
        TransactionHelper("GP Consultation with Dr. Emily Smith","$20.00","Paid","18", "Thu"),
        TransactionHelper("GP Consultation with Dr. Emily Smith","$20.00","Paid","26", "Fri"),
    )
}