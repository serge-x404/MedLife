package com.serge.medlife.roomdb

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.serge.medlife.R

@Entity(tableName = "cart_table")
data class CartItems(
    @PrimaryKey val id: Int = 0,
    val image: Int = 0,
    val medicineName: String = "",
    val price: Double = 0.0
)

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
