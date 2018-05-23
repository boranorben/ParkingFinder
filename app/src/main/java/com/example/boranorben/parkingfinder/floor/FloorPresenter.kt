package com.example.boranorben.parkingfinder.floor

import com.example.boranorben.parkingfinder.home.Building
import com.example.boranorben.parkingfinder.slots.Slots

class FloorPresenter(val view: FloorView) {
    private lateinit var floor: Floor
    private var floorNum: Int = 0

    fun start() {
        view.addButton()
        view.display()
    }

    fun onFirstFlrBtnClicked() {
        floorNum = 1
        setFloor()
    }

    fun onSecondFlrBtnClicked() {
        floorNum = 2
        setFloor()
    }

    fun onThirdFlrBtnClicked() {
        floorNum = 3
        setFloor()
    }

    fun onForthFlrBtnClicked() {
        floorNum = 4
        setFloor()
    }

    private fun setFloor() {
        floor = Floor(floorNum)
        view.navigateToNextAct(floorNum)
    }

    fun getEmptySlots(): String {
        return floor.getEmptySlots().toString()
    }

    fun getSlots(): ArrayList<Slots> {
        return floor.getAllSlots()
    }
}