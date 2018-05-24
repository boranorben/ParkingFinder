package com.example.boranorben.parkingfinder.home

import java.util.*

class Home {
    private var buildingSize: Int = 2
    private var buildings: ArrayList<Building> = ArrayList()
    private val random: Random = Random()

    constructor() {
        for (i in 1..buildingSize) {
            buildings.add(Building(i))
        }
    }

    fun getBuilding(i: Int): Building {
        return buildings.get(i)
    }

    fun randomParking() {
        val cars: Int = rand(0, 65)
        for (i in 0..cars) {
            val bldg: Int = rand(0, 2)
            val flr: Int = rand(0, 4)
            val slots: Int = rand(0, 8)
            buildings[bldg].getFloor()[flr].getAllSlots()[slots].setFull()
        }
    }

    fun rand(from: Int, to: Int) : Int {
        return random.nextInt(to - from) + from
    }
}