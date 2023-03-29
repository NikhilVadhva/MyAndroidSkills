package com.example.myandroidskills.model.repo.product

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.myandroidskills.model.api.ApiService
import com.example.myandroidskills.model.db.AppDatabase
import com.example.myandroidskills.model.db.entities.product.Product
import retrofit2.Response
import javax.inject.Inject

class ProductRepository @Inject constructor(
    private val apiService: ApiService,
    private val appDatabase: AppDatabase
) {

    private val _products = MutableLiveData<List<Product>>()
    val products: LiveData<List<Product>>
        get() = _products

    suspend fun getProducts() {
        val result = apiService.getProducts()
        if (result.isSuccessful && result.body() != null) {
            // save data into db
            appDatabase.getProductDao().addProducts(result.body()!!)
            _products.postValue(result.body())
        }
    }


}