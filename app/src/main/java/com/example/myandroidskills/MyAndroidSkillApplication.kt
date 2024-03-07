package com.example.myandroidskills

import android.app.Application
import dagger.hilt.android.HiltAndroidApp


@HiltAndroidApp
class MyAndroidSkillApplication : Application() {

    override fun onCreate() {
        super.onCreate()

    }


}