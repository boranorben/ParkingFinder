package com.example.boranorben.parkingfinder.home

interface HomeView {
    fun navigateToNextAct(value: Int)
    fun displayFirstBldgEmptySlots(string: String)
    fun displaySecondBldgEmptySlots(string: String)
}