package com.example.boranorben.parkingfinder.home

import com.example.boranorben.parkingfinder.floor.Floor

class Building {
    private var buildingSize: Int = 4
    var floors = ArrayList<Floor>()
    var buildingNum: Int = 0
    var buildingName: String = "Building"
    var emptySlots = 0

    constructor(buildingNum: Int, buildingName: String) {
        this.buildingNum = buildingNum
        this.buildingName = buildingName
        this.floors = ArrayList()
        for (i in 0..(buildingSize - 1)) {
            floors.add(Floor(i + 1))
        }
    }

    fun getCount(): Int {
        for (i in 0..(floors.size - 1)) {
            for (j in 0..(floors.get(i).getSlotsList().size - 1)) {
                if (!floors.get(i).getSlotsList().get(j).isFull()) {
                    emptySlots++
                }
            }
        }
        return emptySlots
    }

    fun getName(): String {
        return this.buildingName
    }
}