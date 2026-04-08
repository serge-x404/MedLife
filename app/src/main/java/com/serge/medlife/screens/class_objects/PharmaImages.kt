package com.serge.medlife.screens.class_objects

import com.serge.medlife.R
import com.serge.medlife.roomdb.CartItems


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

object Medicines {
    val medicineData = listOf(
        CartItems(
            1,
            R.drawable.mylanta,
            "Paracetamol",
            80.00
        ),
        CartItems(
            2,
            R.drawable.mylanta,
            "Crocin",
            70.00
        ),
        CartItems(
            3,
            R.drawable.mylanta,
            "LevoCetM",
            40.00
        ),
        CartItems(
            4,
            R.drawable.mylanta,
            "Pressure Less",
            90.00
        )
    )
}