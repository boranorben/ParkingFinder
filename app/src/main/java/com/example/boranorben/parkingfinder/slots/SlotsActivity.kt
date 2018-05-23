package com.example.boranorben.parkingfinder.slots

import android.content.Intent
import android.graphics.Color
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import com.example.boranorben.parkingfinder.R
import com.example.boranorben.parkingfinder.popup.PopupActivity
import kotlinx.android.synthetic.main.activity_slots.*

class SlotsActivity : AppCompatActivity(), SlotsView{
    private lateinit var presenter: SlotsPresenter
    private var slotTextList: ArrayList<TextView> = ArrayList()
    private lateinit var idArray: ArrayList<String>
    private lateinit var statusArray: ArrayList<Int>
    private var slotsList: ArrayList<Slots> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_slots)
        presenter = SlotsPresenter(this)
        presenter.start()
    }

    fun parkedBtnClicked(view: View) {
        presenter.onParkedBtnClick()
    }

    override fun addTextView() {
        slotTextList.add(slot1)
        slotTextList.add(slot2)
        slotTextList.add(slot3)
        slotTextList.add(slot4)
        slotTextList.add(slot5)
        slotTextList.add(slot6)
        slotTextList.add(slot7)
        slotTextList.add(slot8)
    }

    override fun display() {
        val extras: Bundle = intent.extras
        val buildingNum: Int = extras.getInt("buildingNumber")
        val floorNum: Int = extras.getInt("floorNumber")
        val empty: Int = extras.getInt("emptySlots")
        idArray = extras.getStringArrayList("idArray")
        statusArray = extras.getIntegerArrayList("statusArray")
        location.text = "Building: " + buildingNum + ", Floor: " + floorNum
        avaliableSlots.text = "Avaliable Slots: " + empty
    }

    override fun addSlotsList() {
        for (i in 0..7) {
            slotsList.add(Slots(idArray[i], statusArray[i]))
        }
    }

    override fun displayStatus() {
        for (i in 0..(slotsList.size - 1)) {
            slotTextList[i].text = slotsList.get(i).getId()
            if (slotsList[i].isFull()) {
                slotTextList[i].setTextColor(Color.RED)
            } else {
                slotTextList[i].setTextColor(Color.GREEN)
            }
        }
    }

    override fun openPopup() {
        val intent = Intent(this, PopupActivity::class.java)
        startActivity(intent)
    }

}
