package com.example.boranorben.parkingfinder.home

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.boranorben.parkingfinder.ActivityView
import com.example.boranorben.parkingfinder.floor.FloorActivity
import com.example.boranorben.parkingfinder.R

class HomeActivity : AppCompatActivity(), ActivityView {
    lateinit var presenter: HomePresenter;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        presenter = HomePresenter(this);
    }

    fun firstBldgBtnClicked(view: View) {
        presenter.onFirstBldgBtnClicked()
    }

    fun secondBldgClicked(view: View) {
        presenter.onSecondBldgBtnClicked()
    }

    override fun navigateToNextAct(value: Int) {
        val intent = Intent(this, FloorActivity::class.java)
        intent.putExtra("buildingNumber", value.toString())
        startActivity(intent)
    }

}
