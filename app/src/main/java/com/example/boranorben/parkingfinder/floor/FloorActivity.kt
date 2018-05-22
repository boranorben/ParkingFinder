package com.example.boranorben.parkingfinder.floor

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.boranorben.parkingfinder.ActivityView
import com.example.boranorben.parkingfinder.R
import com.example.boranorben.parkingfinder.SlotsActivity
import kotlinx.android.synthetic.main.activity_floor.*

class FloorActivity : AppCompatActivity(), ActivityView {
    lateinit var presenter: FloorPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_floor)
        displayBuilding()
        presenter = FloorPresenter(this)
    }

    fun firstFlrBtnClicked(view: View) {
        presenter.onFirstFlrBtnClicked()
    }

    fun secondFlrBtnClicked(view: View) {
        presenter.onSecondFlrBtnClicked()
    }

    fun thirdFlrBtnClicked(view: View) {
        presenter.onThirdFlrBtnClicked()
    }

    fun forthFlrBtnClicked(view: View) {
        presenter.onForthFlrBtnClicked()
    }

    fun displayBuilding() {
        val building: String = intent.getStringExtra("buildingNumber")
        bldgNumber.text = "Building: " + building
    }

    override fun navigateToNextAct(value: Int) {
        val intent = Intent(this, SlotsActivity::class.java)
        intent.putExtra("floorNumber", value.toString())
        startActivity(intent)
    }

}
