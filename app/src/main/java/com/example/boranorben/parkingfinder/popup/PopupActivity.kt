package com.example.boranorben.parkingfinder.popup

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.DisplayMetrics
import com.example.boranorben.parkingfinder.R

class PopupActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_popup)

        val dm: DisplayMetrics = DisplayMetrics()
        windowManager.defaultDisplay.getMetrics(dm)

        var width: Int = dm.widthPixels
        var height: Int = dm.heightPixels

        window.setLayout((width*.8).toInt(), (height*.4).toInt())
    }
}
