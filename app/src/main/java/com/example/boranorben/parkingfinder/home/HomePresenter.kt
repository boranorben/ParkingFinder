package com.example.boranorben.parkingfinder.home

class HomePresenter(val view: BuildingView) {
    private var buildingSize = 2
    lateinit var buildings: ArrayList<Building>
    var buildingNum: Int = 0

    fun start() {
        buildings = ArrayList()
        for (i in 1..buildingSize) {
            buildings.add(Building(i))
        }
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
        var string: String = "1st Building: " + buildings.get(0).getEmptySlots()
        view.showFirstBldgEmptySlots(string)
    }

    fun showSecondBldgSlots() {
        var string: String = "2nd Building: " + buildings.get(1).getEmptySlots()
        view.showSecondBldgEmptySlots(string)
    }
}