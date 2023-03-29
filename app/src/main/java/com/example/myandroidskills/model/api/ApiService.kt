package com.example.myandroidskills.model.api

import com.example.myandroidskills.model.db.entities.product.Product
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {
    @GET("products")
    suspend fun getProducts(): Response<List<Product>>
}