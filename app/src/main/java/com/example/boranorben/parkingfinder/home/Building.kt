package com.example.boranorben.parkingfinder.home

import com.example.boranorben.parkingfinder.floor.Floor

class Building {
    private var buildingSize: Int = 4
    var floors = ArrayList<Floor>()
    var buildingNum: Int = 0
    var empty = 0

    constructor(buildingNum: Int) {
        this.buildingNum = buildingNum
        this.floors = ArrayList()
        for (i in 0..(buildingSize - 1)) {
            floors.add(Floor(i + 1))
        }
    }

    fun getFloor(i: Int): Floor {
        return this.floors.get(i)
    }

    fun getEmptySlots(): Int {
        for (floor in floors) {
            empty += floor.getEmptySlots()
        }
        return empty
    }
}