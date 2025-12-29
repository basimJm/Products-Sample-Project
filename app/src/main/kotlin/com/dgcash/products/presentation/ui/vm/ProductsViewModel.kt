package com.dgcash.products.presentation.ui.vm

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.dgcash.products.domain.entity.ProductItemModel
import com.dgcash.products.domain.repository.ProductRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import jakarta.inject.Inject
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

@HiltViewModel
class ProductsViewModel @Inject constructor(private val productRepository: ProductRepository) :
    ViewModel() {
    private var _productList: MutableStateFlow<List<ProductItemModel>> =
        MutableStateFlow(emptyList())
    val productList: StateFlow<List<ProductItemModel>> = _productList

    private var _isLoading: MutableStateFlow<Boolean> = MutableStateFlow(false)
    val isLoading: StateFlow<Boolean> = _isLoading

    private var _errorMessage: MutableStateFlow<String?> = MutableStateFlow(null)
    val errorMessage: StateFlow<String?> = _errorMessage


    init {
        fetchProductList()
    }

    private fun fetchProductList() {
        viewModelScope.launch {
            _isLoading.value = true

            try {
                val response = productRepository.getProductList()
                _productList.value = response
            } catch (e: Exception) {
                _errorMessage.value = e.message
                Log.e("ProductsViewModel", "Error fetching product list : ${e.message.toString()}" )
            } finally {
                _isLoading.value = false
            }
        }
    }
}