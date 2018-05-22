package com.example.boranorben.parkingfinder.floor

class FloorPresenter(val view: FloorView) {
    lateinit var floor: Floor
    var floorNum: Int = 0

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

    fun setFloor() {
        view.navigateToNextAct(floorNum)
    }
}