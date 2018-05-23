package com.example.boranorben.parkingfinder.home

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.boranorben.parkingfinder.floor.FloorActivity
import com.example.boranorben.parkingfinder.R
import kotlinx.android.synthetic.main.activity_home.*

class HomeActivity : AppCompatActivity(), HomeView {
    private lateinit var presenter: HomePresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        presenter = HomePresenter(this)
        presenter.start()
    }

    fun firstBldgBtnClicked(view: View) {
        presenter.onFirstBldgBtnClicked()
    }

    fun secondBldgClicked(view: View) {
        presenter.onSecondBldgBtnClicked()
    }

    override fun navigateToNextAct(value: Int) {
        val intent = Intent(this, FloorActivity::class.java)
        val extras = Bundle()
        extras.putInt("buildingNumber", value)
        extras.putParcelableArrayList("floorsList", presenter.getFloor())
        intent.putExtras(extras)
        startActivity(intent)
    }

    override fun displayFirstBldgEmptySlots(string: String) {
        firstBldgBtn.text = string
    }

    override fun displaySecondBldgEmptySlots(string: String) {
        secondBldgBtn.text = string
    }
}