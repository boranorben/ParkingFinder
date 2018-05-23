package com.example.boranorben.parkingfinder.home

class Home {
    private var buildingSize = 2
    var buildings: ArrayList<Building>

    constructor() {
        buildings = ArrayList()
        for (i in 1..buildingSize) {
            buildings.add(Building(i))
        }
    }

    fun getBuilding(i: Int): Building {
        return buildings.get(i)
    }
}