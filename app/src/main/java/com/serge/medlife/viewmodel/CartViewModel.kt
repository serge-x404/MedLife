package com.serge.medlife.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.serge.medlife.repository.CartRepository
import com.serge.medlife.roomdb.CartItems
import kotlinx.coroutines.launch

class CartViewModel(
    private val repository: CartRepository
): ViewModel() {
    val allCartItems = repository.allCartItems

    fun addToCart(cartItems: CartItems) = viewModelScope.launch {
        repository.addToCart(cartItems)
    }

    fun removeFromCart(cartItems: CartItems) = viewModelScope.launch {
        repository.removeFromCart(cartItems)
    }

    fun clearCart() = viewModelScope.launch {
        repository.clearCart()
    }

    fun totalAmount(items: List<CartItems>): Double {
        return items.sumOf { it.price }
    }
}