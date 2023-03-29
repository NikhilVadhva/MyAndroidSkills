package com.example.myandroidskills.model.db.dao.product

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.myandroidskills.model.db.entities.product.Product

@Dao
interface ProductDAO {

    @Insert
    suspend fun addProducts(product : List<Product>)

    @Query("SELECT * FROM Product")
    suspend fun getProducts() : List<Product>


}