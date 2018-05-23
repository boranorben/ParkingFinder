package com.example.boranorben.parkingfinder.slots

import android.content.Intent
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
        val building: String = extras.getString("buildingNumber")
        val floor: String = extras.getString("floorNumber")
        val empty: String = extras.getString("emptySlots")
        val slotsList: ArrayList<Slots> = extras.getParcelableArrayList<Slots>("slotsList")
        location.text = "Building: " + building + ", Floor: " + floor
        avaliableSlots.text = "Avaliable Slots: " + empty
        for (i in 0..(slotsList.size - 1)) {
            slotTextList.get(i).text = slotsList.get(i).getId()
        }
    }

    override fun openPopup() {
        val intent = Intent(this, PopupActivity::class.java)
        startActivity(intent)
    }

}
