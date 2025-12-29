package com.dgcash.products.domain.entity

data class ProductItemModel(
    val availabilityStatus: String,
    val brand: String,
    val description: String,
    val id: Int,
    val price: Double,
    val tags: List<String>,
    val thumbnail: String,
    val title: String,
)
