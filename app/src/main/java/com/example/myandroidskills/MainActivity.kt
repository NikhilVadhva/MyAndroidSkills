package com.example.myandroidskills

import android.annotation.SuppressLint
import android.os.Build
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.CheckBox
import androidx.appcompat.app.AppCompatActivity
import com.example.myandroidskills.utils.Utils
import com.helpscout.beacon.Beacon
import com.helpscout.beacon.internal.core.model.ContactFormConfigApi
import com.helpscout.beacon.model.BeaconConfigOverrides
import com.helpscout.beacon.model.PreFilledForm
import com.helpscout.beacon.ui.BeaconActivity


class MainActivity : AppCompatActivity() {
    private val TAG = javaClass.name
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Log.d(TAG,"My Msg")
    }

}