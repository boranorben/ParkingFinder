package com.example.boranorben.parkingfinder.home

class HomePresenter(val view: BuildingView) {
    lateinit var building1: Building
    lateinit var building2: Building
    var buildingNum: Int = 0

    fun start() {
        building1 = Building(1, "1ST Building")
        building2 = Building(2, "2ND Building")
        showFirstBldgSlots()
        showSecondBldgSlots()
    }

    fun onFirstBldgBtnClicked() {
        buildingNum = 1;
        setBuilding()
    }

    fun onSecondBldgBtnClicked() {
        buildingNum = 2;
        setBuilding()
    }

    fun setBuilding() {
        view.navigateToNextAct(buildingNum);
    }

    fun showFirstBldgSlots() {
        var string: String = building1.getName() + ": " + building1.getCount()
        view.showFirstBldgEmptySlots(string)
    }

    fun showSecondBldgSlots() {
        var string: String = building2.getName() + ": " + building2.getCount()
        view.showSecondBldgEmptySlots(string)
    }
}