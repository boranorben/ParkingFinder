package com.example.boranorben.parkingfinder.floor

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.boranorben.parkingfinder.R
import com.example.boranorben.parkingfinder.slots.SlotsActivity
import kotlinx.android.synthetic.main.activity_floor.*

class FloorActivity : AppCompatActivity(), FloorView {
    lateinit var presenter: FloorPresenter
    var buildingNum: String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_floor)
        presenter = FloorPresenter(this)
        presenter.start()
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

    override fun display() {
        val extras: Bundle = intent.extras
        val building: String = extras.getString("buildingNumber")
        val firstFloor: String = extras.getString("firstFlrSlots")
        val secondFloor: String = extras.getString("secondFlrSlots")
        val thirdFloor: String = extras.getString("thirdFlrSlots")
        val forthFloor: String = extras.getString("forthFlrSlots")
        buildingNum = building
        bldgNumber.text = "Building: " + building
        firstFlrBtn.text = "1st Floor: " + firstFloor
        secondFlrBtn.text = "2nd Floor: " + secondFloor
        thirdFlrBtn.text = "3rd Floor: " + thirdFloor
        forthFlrBtn.text = "4th Floor: " + forthFloor
    }

    override fun navigateToNextAct(value: Int) {
        val intent = Intent(this, SlotsActivity::class.java)
        val extras = Bundle()
        extras.putString("buildingNumber", buildingNum)
        extras.putString("floorNumber", value.toString())
        extras.putString("emptySlots", presenter.getSlots())
        intent.putExtras(extras)
        startActivity(intent)
    }

}
