package com.example.boranorben.parkingfinder

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_floor.*

class FloorActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_floor)
        val building: String = intent.getStringExtra("buildingNumber")
        bldgNumber.text = "Building: " + building
    }

    fun onFirstFlrBtnClicked(view: View) {
        newActivity(1)
    }

    fun onSecondFlrBtnClicked(view: View) {
        newActivity(2)
    }

    fun onThirdFlrBtnClicked(view: View) {
        newActivity(3)
    }

    fun onForthFlrBtnClicked(view: View) {
        newActivity(4)
    }

    private fun newActivity(floorNumber: Int) {
        val intent = Intent(this, SlotsActivity::class.java)
        intent.putExtra("floorNumber", floorNumber.toString())
        startActivity(intent)
    }

}
