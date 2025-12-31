package com.dgcash.products.presentation.ui.vm

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.dgcash.products.domain.entity.ProductItemModel
import com.dgcash.products.domain.repository.ProductRepository
import com.dgcash.products.presentation.utils.Constants
import dagger.hilt.android.lifecycle.HiltViewModel
import jakarta.inject.Inject
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

@HiltViewModel
class ProductDetailsViewModel @Inject constructor(
    private val productRepository: ProductRepository,
    private val savedStateHandle: SavedStateHandle
) : ViewModel() {
    private var _product: MutableStateFlow<ProductItemModel?> =
        MutableStateFlow(null)

    val product: StateFlow<ProductItemModel?> = _product

    private var _isLoading: MutableStateFlow<Boolean> = MutableStateFlow(false)
    val isLoading: StateFlow<Boolean> = _isLoading

    private var _errorMessage: MutableStateFlow<String?> = MutableStateFlow(null)
    val errorMessage: StateFlow<String?> = _errorMessage

    init {
        val id = savedStateHandle.get<String>(Constants.PRODUCT_ID)
        getProductDetails(id)
    }

    private fun getProductDetails(id: String?) {
        id?.let { productId ->
            viewModelScope.launch {
                _isLoading.emit(true)
                try {
                    val response = productRepository.getProductById(productId)
                    _product.emit(response)

                } catch (e: Exception) {
                    _errorMessage.emit(e.message.toString())
                } finally {
                    _isLoading.emit(false)
                }
            }
        }
    }
}