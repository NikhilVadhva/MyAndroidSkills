package com.example.myandroidskills.model.db.dao.quote

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.myandroidskills.model.db.entities.quote.Quote

@Dao
interface QuoteDAO {
    @Query("SELECT * from quote")
    fun getQuotes(): LiveData<List<Quote>>

    @Insert
    suspend fun insertQuote(quote: Quote)
}