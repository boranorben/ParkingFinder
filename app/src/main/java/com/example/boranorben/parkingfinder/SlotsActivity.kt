package com.example.boranorben.parkingfinder

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_slots.*

class SlotsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_slots)

        val floor: String = intent.getStringExtra("floorNumber")

        location.text = " Floor: " + floor
    }
}
