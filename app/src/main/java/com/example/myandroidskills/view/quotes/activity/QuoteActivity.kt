package com.example.myandroidskills.view.quotes.activity

import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.myandroidskills.R
import com.example.myandroidskills.base.BaseActivity
import com.example.myandroidskills.databinding.ActivityQuoteBinding
import com.example.myandroidskills.model.db.entities.quote.Quote
import com.example.myandroidskills.viewModel.quotes.QuoteViewModel

class QuoteActivity : BaseActivity() {

    private lateinit var binding : ActivityQuoteBinding
    private lateinit var quoteViewModel: QuoteViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        init()
        setOnClickListener()
        setObservables()
    }


    private fun init()
    {
        binding = DataBindingUtil.setContentView(this, R.layout.activity_quote)
//        val quoteDao = AppDatabase.getDatabase(applicationContext).quoteDao()
//        val quoteRepository = QuoteRepository(quoteDao)
        quoteViewModel = ViewModelProvider(this,)[QuoteViewModel::class.java]
    }

    private fun setOnClickListener()
    {
        binding.btnAddQuote.setOnClickListener {
            val quote = Quote(0, "Testing my Arch", "Nikhil Singh")
            quoteViewModel.insertQuote(quote)
        }
    }

    private fun setObservables() {

        quoteViewModel.getQuote().observe(this) { quotes ->
            // set quotes
            binding.quotes = quotes.toString()
        }
    }


}