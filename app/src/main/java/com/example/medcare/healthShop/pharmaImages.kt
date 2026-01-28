package com.example.medcare.healthShop

import com.example.medcare.R


data class HotSales(
    val image: Int,
    val medicineName: String
)

object pharmaImages {
    val PharmaImages = listOf(
        R.drawable.kalbe,
        R.drawable.kimia,
        R.drawable.dexa
    )

    val hotSales = listOf(
        HotSales(R.drawable.promag,"Promag 10tablets"),
        HotSales(R.drawable.neurodex,"Strip Neurodex 10 tablets"),
        HotSales(R.drawable.neurodex,"Strip Neurodex 10 tablets"),
        HotSales(R.drawable.neurodex,"Strip Neurodex 10 tablets"),
    )
}