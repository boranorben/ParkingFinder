package com.example.boranorben.parkingfinder.home

import com.example.boranorben.parkingfinder.floor.Floor

class HomePresenter(val view: HomeView) {
    private var buildingNum: Int = 0
    private lateinit var home: Home

    fun start() {
        home = Home()
        displayFirstBldgSlots()
        displaySecondBldgSlots()
    }

    fun onFirstBldgBtnClicked() {
        buildingNum = 1;
        setBuilding()
    }

    fun onSecondBldgBtnClicked() {
        buildingNum = 2;
        setBuilding()
    }

    private fun setBuilding() {
        view.navigateToNextAct(buildingNum);
    }

    private fun displayFirstBldgSlots() {
        var string: String = "1st Building: " + home.getBuilding(0).getBldgEmptySlots()
        view.displayFirstBldgEmptySlots(string)
    }

    private fun displaySecondBldgSlots() {
        var string: String = "2nd Building: " + home.getBuilding(1).getBldgEmptySlots()
        view.displaySecondBldgEmptySlots(string)
    }

    fun getFloor(): ArrayList<Floor> {
        return home.getBuilding(buildingNum - 1).getFloor()
    }
}