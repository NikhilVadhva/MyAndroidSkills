package com.example.myandroidskills.model.repo.quote

import androidx.lifecycle.LiveData
import com.example.myandroidskills.model.db.dao.quote.QuoteDAO
import com.example.myandroidskills.model.db.entities.quote.Quote

class QuoteRepository( private val quoteDao : QuoteDAO) {

    fun getQuotes() : LiveData<List<Quote>>{
         return quoteDao.getQuotes()
    }

    suspend fun insertQuote(quote: Quote)
    {
         quoteDao.insertQuote(quote)
    }
}