package com.example.boranorben.parkingfinder.slots

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.boranorben.parkingfinder.R
import com.example.boranorben.parkingfinder.popup.PopupActivity
import kotlinx.android.synthetic.main.activity_slots.*

class SlotsActivity : AppCompatActivity(), SlotsView{
    lateinit var presenter: SlotsPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_slots)
        presenter = SlotsPresenter(this)
        presenter.start()
    }

    fun parkedBtnClicked(view: View) {
        presenter.onParkedBtnClick()
    }

    override fun display() {
        val extras: Bundle = intent.extras
        val building: String = extras.getString("buildingNumber")
        val floor: String = extras.getString("floorNumber")
        val empty: String = extras.getString("emptySlots")
        location.text = "Building: " + building + ", Floor: " + floor
        avaliableSlots.text = "Avaliable Slots: " + empty
    }

    override fun openPopup() {
        val intent = Intent(this, PopupActivity::class.java)
        startActivity(intent)
    }

}
