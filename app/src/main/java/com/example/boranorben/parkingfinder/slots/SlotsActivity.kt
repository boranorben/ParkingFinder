package com.example.boranorben.parkingfinder.slots

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.example.boranorben.parkingfinder.R
import kotlinx.android.synthetic.main.activity_slots.*

class SlotsActivity : AppCompatActivity(), SlotsView{

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_slots)
        displayLocation()
    }

    fun displayLocation() {
        val extras: Bundle = intent.extras
        val building: String = extras.getString("buildingNumber")
        val floor: String = extras.getString("floorNumber")
        location.text = "Building: " + building + ", Floor: " + floor
    }
}
