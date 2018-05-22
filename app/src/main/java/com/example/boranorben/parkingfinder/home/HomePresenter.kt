package com.example.boranorben.parkingfinder.home

import com.example.boranorben.parkingfinder.ActivityView

class HomePresenter(val view: ActivityView) {
    var building: Int = 0;

    fun onFirstBldgBtnClicked() {
        building = 1;
        setBuilding()
    }

    fun onSecondBldgBtnClicked() {
        building = 2;
        setBuilding()
    }

    fun setBuilding() {
        view.navigateToNextAct(building);
    }

}