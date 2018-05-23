package com.example.boranorben.parkingfinder.home

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.boranorben.parkingfinder.floor.FloorActivity
import com.example.boranorben.parkingfinder.R
import kotlinx.android.synthetic.main.activity_home.*

class HomeActivity : AppCompatActivity(), HomeView {
    lateinit var presenter: HomePresenter

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
        extras.putString("buildingNumber", value.toString())
        extras.putString("firstFlrSlots", presenter.getFirstFlrSlots())
        extras.putString("secondFlrSlots", presenter.getSecondFlrSlots())
        extras.putString("thirdFlrSlots", presenter.getThirdFlrSlots())
        extras.putString("forthFlrSlots", presenter.getForthFlrSlots())
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