package com.dgcash.products.data.remote.model

import com.dgcash.products.domain.entity.ProductItemModel
import com.dgcash.products.domain.mapper.ModelMapper

data class ProductItemRemoteResponse(
    val availabilityStatus: String,
    val brand: String?,
    val category: String,
    val description: String,
    val dimensions: DimensionsRemoteResponse,
    val discountPercentage: Double,
    val id: Int,
    val images: List<String>,
    val meta: MetaRemoteResponse,
    val minimumOrderQuantity: Int,
    val price: Double,
    val rating: Double,
    val returnPolicy: String,
    val reviews: List<ReviewRemoteResponse>,
    val shippingInformation: String,
    val sku: String,
    val stock: Int,
    val tags: List<String>,
    val thumbnail: String,
    val title: String,
    val warrantyInformation: String,
    val weight: Int
) : ModelMapper<ProductItemModel> {
    override fun toEntity(): ProductItemModel {
        return ProductItemModel(
            availabilityStatus = availabilityStatus,
            brand = brand?:"test",
            description = description,
            id = id,
            price = price,
            tags = tags,
            thumbnail = thumbnail,
            title = title
        )
    }


}