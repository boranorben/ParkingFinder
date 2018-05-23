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
    private var buildingNum: String = ""

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
        val building: String = extras.getString("buildingNumber")
        val floorList: ArrayList<Floor> = extras.getParcelableArrayList("floorsList")
        for (floor in floorList) {
            println(floor.getEmptySlots())
        }
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
        val intent = Intent(this, SlotsActivity::class.java)
        val extras = Bundle()
        extras.putString("buildingNumber", buildingNum)
        extras.putString("floorNumber", value.toString())
        extras.putString("emptySlots", presenter.getEmptySlots())
        extras.putParcelableArrayList("slotsList", presenter.getSlots())
        intent.putExtras(extras)
        startActivity(intent)
    }

}
