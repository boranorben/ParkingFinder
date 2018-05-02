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
        val intent = Intent(this, FloorActivity::class.java)
        intent.putExtra("BuildingNumber", 1.toString())
        startActivity(intent)
    }

    fun secondBldgClicked(view: View) {
        val intent = Intent(this, FloorActivity::class.java)
        intent.putExtra("BuildingNumber", 2.toString())
        startActivity(intent)
    }

}
