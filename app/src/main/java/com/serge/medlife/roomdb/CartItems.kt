package com.serge.medlife.roomdb

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "cart_table")
data class CartItems(
    @PrimaryKey val id: String = "",
    val image: Int = 0,
    val medicineName: String = "",
    val price: Double = 0.0
)
