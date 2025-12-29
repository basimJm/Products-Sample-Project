package com.dgcash.products.data.remote.data_source

import com.dgcash.products.data.remote.model.ProductItemRemoteResponse
import com.dgcash.products.data.remote.model.ProductsListRemoteResponse
import retrofit2.http.GET
import retrofit2.http.Path

interface ProductApiService {
    @GET("/products")
    suspend fun getProducts(): ProductsListRemoteResponse

    @GET("/products/{id}")
    suspend fun getProductById(@Path("id") id: String): ProductItemRemoteResponse
}