package com.example.medcare.class_objects

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

    val medicineGrid = listOf(
        HotSales(R.drawable.promag,"Promag 10 tablets"),
        HotSales(R.drawable.neurodex,"Strip Neurodex 10 tablets"),
        HotSales(R.drawable.mylanta,"Mylantra Strip"),
        HotSales(R.drawable.bufect,"Bufect Strip"),
        HotSales(R.drawable.bordex,"Boredex Medicine"),
        HotSales(R.drawable.paratusin,"Paratusin"),
    )

    val cartCards = listOf(
        HotSales(R.drawable.bufect,"Bufect Strip"),
        HotSales(R.drawable.neurodex,"Strip Neurodex"),
        HotSales(R.drawable.bufect,"Bufect Strip"),
    )
}