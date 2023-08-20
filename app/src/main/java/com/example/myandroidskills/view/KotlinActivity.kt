package com.example.myandroidskills.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.myandroidskills.R

class KotlinActivity : AppCompatActivity() {
    val TAG = this.javaClass.name
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_kotlin)
        Log.d(TAG,"Checking Commit After Multiple GitHub Account in Kotlin")

    }
}