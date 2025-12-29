package com.dgcash.products.data.repository

import com.dgcash.products.data.remote.data_source.ProductApiService
import com.dgcash.products.domain.entity.ProductItemModel
import com.dgcash.products.domain.repository.ProductRepository
import jakarta.inject.Inject

class ProductRepositoryImpl @Inject constructor(private val productApiService: ProductApiService) :
    ProductRepository {
    override suspend fun getProductList(): List<ProductItemModel> {
        return productApiService.getProducts().products.map { it.toEntity() }
    }

    override suspend fun getProductById(id: String): ProductItemModel {
        return productApiService.getProductById(id).toEntity()
    }
}