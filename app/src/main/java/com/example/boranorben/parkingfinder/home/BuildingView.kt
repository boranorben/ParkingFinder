package com.example.boranorben.parkingfinder.home

interface BuildingView {
    fun navigateToNextAct(value: Int);
    fun showFirstBldgEmptySlots(string: String);
    fun showSecondBldgEmptySlots(string: String);
}