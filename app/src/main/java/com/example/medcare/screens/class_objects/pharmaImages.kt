package com.example.medcare.screens.class_objects

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
        _root_ide_package_.com.example.medcare.screens.class_objects.HotSales(
            R.drawable.promag,
            "Promag 10tablets"
        ),
        _root_ide_package_.com.example.medcare.screens.class_objects.HotSales(
            R.drawable.neurodex,
            "Strip Neurodex 10 tablets"
        ),
        _root_ide_package_.com.example.medcare.screens.class_objects.HotSales(
            R.drawable.neurodex,
            "Strip Neurodex 10 tablets"
        ),
        _root_ide_package_.com.example.medcare.screens.class_objects.HotSales(
            R.drawable.neurodex,
            "Strip Neurodex 10 tablets"
        ),
    )

    val medicineGrid = listOf(
        _root_ide_package_.com.example.medcare.screens.class_objects.HotSales(
            R.drawable.promag,
            "Promag 10 tablets"
        ),
        _root_ide_package_.com.example.medcare.screens.class_objects.HotSales(
            R.drawable.neurodex,
            "Strip Neurodex 10 tablets"
        ),
        _root_ide_package_.com.example.medcare.screens.class_objects.HotSales(
            R.drawable.mylanta,
            "Mylantra Strip"
        ),
        _root_ide_package_.com.example.medcare.screens.class_objects.HotSales(
            R.drawable.bufect,
            "Bufect Strip"
        ),
        _root_ide_package_.com.example.medcare.screens.class_objects.HotSales(
            R.drawable.bordex,
            "Boredex Medicine"
        ),
        _root_ide_package_.com.example.medcare.screens.class_objects.HotSales(
            R.drawable.paratusin,
            "Paratusin"
        ),
    )

    val cartCards = listOf(
        _root_ide_package_.com.example.medcare.screens.class_objects.HotSales(
            R.drawable.bufect,
            "Bufect Strip"
        ),
        _root_ide_package_.com.example.medcare.screens.class_objects.HotSales(
            R.drawable.neurodex,
            "Strip Neurodex"
        ),
        _root_ide_package_.com.example.medcare.screens.class_objects.HotSales(
            R.drawable.bufect,
            "Bufect Strip"
        ),
    )
}