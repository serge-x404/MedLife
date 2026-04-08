package com.serge.medlife.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.serge.medlife.repository.CartRepository

class CartViewModelFactory(
    private val repository: CartRepository
): ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(CartViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return CartViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel Class")
    }

}