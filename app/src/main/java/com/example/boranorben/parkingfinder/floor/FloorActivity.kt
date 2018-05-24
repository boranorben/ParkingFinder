package com.example.boranorben.parkingfinder.floor

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import com.example.boranorben.parkingfinder.R
import com.example.boranorben.parkingfinder.slots.Slots
import com.example.boranorben.parkingfinder.slots.SlotsActivity
import kotlinx.android.synthetic.main.activity_floor.*

class FloorActivity : AppCompatActivity(), FloorView {
    private lateinit var presenter: FloorPresenter
    private var buttonList: ArrayList<Button> = ArrayList()
    private lateinit var floorList: ArrayList<Floor>
    private var buildingNum: Int = 0

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

    override fun addButton() {
        buttonList.add(firstFlrBtn)
        buttonList.add(secondFlrBtn)
        buttonList.add(thirdFlrBtn)
        buttonList.add(forthFlrBtn)
    }

    override fun display() {
        val extras: Bundle = intent.extras
        val building: Int = extras.getInt("buildingNumber")
        floorList = extras.getParcelableArrayList("floorsList")
        buildingNum = building
        bldgNumber.text = "Building: " + building
        for (i in 0..(floorList.size - 1)) {
            var floorString: String = ""
            if (i == 0) { floorString = "1st" }
            else if (i == 1) { floorString = "2nd" }
            else if (i == 2) { floorString = "3rd" }
            else if (i == 3) { floorString = "4th" }
            buttonList.get(i).text = floorString + " Floor: " + floorList.get(i).getEmptySlots()
        }
    }

    override fun navigateToNextAct(value: Int) {
        presenter.getFloorFromList(value, floorList)
        val intent = Intent(this, SlotsActivity::class.java)
        val extras = Bundle()
        extras.putInt("buildingNumber", buildingNum)
        extras.putInt("floorNumber", value)
        extras.putInt("emptySlots", presenter.getEmptySlots())
        extras.putParcelableArrayList("slots", presenter.getSlots())
        intent.putExtras(extras)
        startActivity(intent)
    }

}
