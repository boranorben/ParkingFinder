package com.example.boranorben.parkingfinder

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun firstBldgBtnClicked(view: View) {
        newActivity(1)
    }

    fun secondBldgClicked(view: View) {
        newActivity(2)
    }

    private fun newActivity(buildingNum: Int) {
        val intent = Intent(this, FloorActivity::class.java)
        intent.putExtra("buildingNumber", buildingNum.toString())
        startActivity(intent)
    }

}
