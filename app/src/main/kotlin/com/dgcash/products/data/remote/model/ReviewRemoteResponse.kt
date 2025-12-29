package com.dgcash.products.data.remote.model

data class ReviewRemoteResponse(
    val comment: String,
    val date: String,
    val rating: Int,
    val reviewerEmail: String,
    val reviewerName: String
)