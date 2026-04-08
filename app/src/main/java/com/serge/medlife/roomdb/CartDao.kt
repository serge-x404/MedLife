package com.serge.medlife.roomdb

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

@Dao
interface CartDao {

    @Insert
    suspend fun insertMedicine(cart: CartItems)

    @Update
    suspend fun updateMedicine(cart: CartItems)

    @Delete
    suspend fun removeMedicine(cart: CartItems)

    @Query("SELECT * FROM cart_table")
    fun getAllCartItems(): List<CartItems>

    @Query("SELECT * FROM cart_table WHERE id = :cartId")
    suspend fun getCartItemById(cartId: String): CartItems?

    @Query("DELETE FROM cart_table")
    suspend fun clearCart()
}