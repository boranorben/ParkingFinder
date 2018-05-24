package com.example.boranorben.parkingfinder.home

import com.example.boranorben.parkingfinder.floor.Floor

class Building {
    private var floorSize: Int = 4
    private var floors: ArrayList<Floor> = ArrayList<Floor>()
    private var buildingNum: Int = 0
    private var empty: Int = 0

    constructor(buildingNum: Int) {
        this.buildingNum = buildingNum
        this.floors = ArrayList()
        for (i in 0..(floorSize - 1)) {
            floors.add(Floor(i + 1))
        }
    }

    fun getFloor(): ArrayList<Floor> {
        return this.floors
    }

    fun getBldgEmptySlots(): Int {
        for (floor in floors) {
            empty += floor.getEmptySlots()
        }
        return empty
    }

}