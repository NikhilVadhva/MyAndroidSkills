package com.example.myandroidskills.base

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.myandroidskills.R

abstract class BaseActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_commons_base)
    }
}