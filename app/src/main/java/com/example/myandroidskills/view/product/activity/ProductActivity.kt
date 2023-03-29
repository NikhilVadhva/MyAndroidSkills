package com.example.myandroidskills.view.product.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.myandroidskills.R
import com.example.myandroidskills.databinding.ActivityProductBinding
import com.example.myandroidskills.viewModel.product.ProductViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ProductActivity : AppCompatActivity() {

    lateinit var productViewModel: ProductViewModel
    lateinit var binding: ActivityProductBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_product)

        init()
        setObservable()
    }

    private fun init() {
        binding = DataBindingUtil.setContentView(this, R.layout.activity_product)


        productViewModel =
            ViewModelProvider(this)[ProductViewModel::class.java]
    }

    private fun setObservable()
    {
         productViewModel.productLiveData.observe(this) { productList ->
             binding.product.text = productList.joinToString { x -> x.title + "\n\n" }
         }
    }
}