package com.example.boranorben.parkingfinder.floor

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.boranorben.parkingfinder.home.BuildingView
import com.example.boranorben.parkingfinder.R
import com.example.boranorben.parkingfinder.slots.SlotsActivity
import kotlinx.android.synthetic.main.activity_floor.*

class FloorActivity : AppCompatActivity(), FloorView {
    lateinit var presenter: FloorPresenter
    var buildingNum: String = ""

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
        buildingNum = building
        bldgNumber.text = "Building: " + building
    }

    override fun navigateToNextAct(value: Int) {
        val intent = Intent(this, SlotsActivity::class.java)
        val extras = Bundle()
        extras.putString("buildingNumber", buildingNum)
        extras.putString("floorNumber", value.toString())
        intent.putExtras(extras)
        startActivity(intent)
    }

}
