package com.dgcash.products.data.remote.model

data class ProductsListRemoteResponse(
    val limit: Int,
    val products: List<ProductItemRemoteResponse>,
    val skip: Int,
    val total: Int
)