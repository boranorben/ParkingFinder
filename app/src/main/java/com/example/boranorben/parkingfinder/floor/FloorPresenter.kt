package com.example.boranorben.parkingfinder.floor

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

    fun getEmptySlots(): Int {
        return floor.getEmptySlots()
    }

    fun getSlotId(): ArrayList<String> {
        var idArray: ArrayList<String> = ArrayList(8)
        println(floor.getEmptySlots())
        for (i in 0..7) {
            println(floor.getAllSlots()[i].getId())
        }
        for (i in 0..7) {
            idArray.add(floor.getAllSlots()[i].getId())
        }
        return idArray
    }

    fun getSlotStatus(): ArrayList<Int> {
        var statusArray: ArrayList<Int> = ArrayList(8)
        for (i in 0..7) {
            statusArray.add(floor.getAllSlots()[i].getFull())
        }
        return statusArray
    }

//    fun getFloorFromList(i: Int, list: ArrayList<Floor>) {
//        this.floor = list[i - 1]
//    }
}