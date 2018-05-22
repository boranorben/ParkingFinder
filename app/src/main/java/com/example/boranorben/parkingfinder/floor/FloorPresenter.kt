package com.example.boranorben.parkingfinder.floor

import com.example.boranorben.parkingfinder.ActivityView

class FloorPresenter(val view: ActivityView) {
    var floor: Int = 0

    fun onFirstFlrBtnClicked() {
        floor = 1
        setFloor()
    }

    fun onSecondFlrBtnClicked() {
        floor = 2
        setFloor()
    }

    fun onThirdFlrBtnClicked() {
        floor = 3
        setFloor()
    }

    fun onForthFlrBtnClicked() {
        floor = 4
        setFloor()
    }

    fun setFloor() {
        view.navigateToNextAct(floor)
    }
}