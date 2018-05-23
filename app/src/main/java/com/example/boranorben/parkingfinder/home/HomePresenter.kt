package com.example.boranorben.parkingfinder.home

class HomePresenter(val view: HomeView) {
    var buildingNum: Int = 0
    lateinit var home: Home

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
        var string: String = "1st Building: " + home.getBuilding(0).getEmptySlots()
        view.displayFirstBldgEmptySlots(string)
    }

    private fun displaySecondBldgSlots() {
        var string: String = "2nd Building: " + home.getBuilding(1).getEmptySlots()
        view.displaySecondBldgEmptySlots(string)
    }

    // duplicated code!
    fun getFirstFlrSlots(): String {
        return home.getBuilding(buildingNum - 1).getFloor(0).getEmptySlots().toString()
    }

    fun getSecondFlrSlots(): String {
        return home.getBuilding(buildingNum - 1).getFloor(1).getEmptySlots().toString()
    }

    fun getThirdFlrSlots(): String {
        return home.getBuilding(buildingNum - 1).getFloor(2).getEmptySlots().toString()
    }

    fun getForthFlrSlots(): String {
        return home.getBuilding(buildingNum - 1).getFloor(3).getEmptySlots().toString()
    }
}