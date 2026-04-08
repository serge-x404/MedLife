package com.serge.medlife.screens.class_objects

import com.serge.medlife.R


data class HotSales(
    val image: Int,
    val medicineName: String
)

object PharmaImages {

    val medicineGrid = listOf(
        HotSales(
            R.drawable.promag,
            "Paracetamol"
        ),
        HotSales(
            R.drawable.promag,
            "Crocin"
        ),
        HotSales(
            R.drawable.mylanta,
            "LevoCetM"
        ),
        HotSales(
            R.drawable.bufect,
            "Pressure Less"
        )
    )

    val cartCards = listOf(
        HotSales(
            R.drawable.bufect,
            "Bufect Strip"
        ),
        HotSales(
            R.drawable.neurodex,
            "Strip Neurodex"
        ),
        HotSales(
            R.drawable.bufect,
            "Bufect Strip"
        ),
    )
}