package com.example.boranorben.parkingfinder.home

class Home {
    private var buildingSize = 2
    private var buildings: ArrayList<Building> = ArrayList()

    constructor() {
        for (i in 1..buildingSize) {
            buildings.add(Building(i))
        }
    }

    fun getBuilding(i: Int): Building {
        return buildings.get(i)
    }
}