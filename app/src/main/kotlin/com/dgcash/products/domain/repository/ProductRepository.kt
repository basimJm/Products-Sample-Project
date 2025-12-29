package com.dgcash.products.domain.repository

import com.dgcash.products.domain.entity.ProductItemModel

interface ProductRepository {
    suspend fun getProductList(): List<ProductItemModel>

    suspend fun getProductById(id: String): ProductItemModel
}