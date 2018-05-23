package com.example.boranorben.parkingfinder.slots

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.example.boranorben.parkingfinder.R
import kotlinx.android.synthetic.main.activity_slots.*

class SlotsActivity : AppCompatActivity(), SlotsView{
    lateinit var presenter: SlotsPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_slots)
        presenter = SlotsPresenter(this)
        presenter.start()
    }

    override fun display() {
        val extras: Bundle = intent.extras
        val building: String = extras.getString("buildingNumber")
        val floor: String = extras.getString("floorNumber")
        val empty: String = extras.getString("emptySlots")
        location.text = "Building: " + building + ", Floor: " + floor
        avaliableSlots.text = "Avaliable Slots: " + empty

    }

}
