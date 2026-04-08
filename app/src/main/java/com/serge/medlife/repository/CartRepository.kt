package com.serge.medlife.repository

import com.serge.medlife.roomdb.CartDao
import com.serge.medlife.roomdb.CartItems

class CartRepository(
    private val cartDao: CartDao
) {

    val allCartItems: List<CartItems> = cartDao.getAllCartItems()

    suspend fun addToCart(cart: CartItems) {
        val existingItem = cartDao.getCartItemById(cart.id)

        if (existingItem != null) {
            cartDao.updateMedicine(cart)
        }
        else {
            cartDao.insertMedicine(cart)
        }
    }

    suspend fun removeFromCart(cart: CartItems) {
        cartDao.removeMedicine(cart)
    }

    suspend fun clearCart() {
        cartDao.clearCart()
    }
}