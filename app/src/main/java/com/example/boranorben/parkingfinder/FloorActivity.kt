package com.example.boranorben.parkingfinder

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_floor.*

class FloorActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_floor)

        val building: String = intent.getStringExtra("BuildingNumber")
        bldgNumber.text = "Building: " + building
    }

}
