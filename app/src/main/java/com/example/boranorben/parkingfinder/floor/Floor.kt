package com.example.boranorben.parkingfinder.floor

import com.example.boranorben.parkingfinder.slots.Slots

class Floor {
    private var slotSize: Int = 8
    var slots = ArrayList<Slots>()
    var floorNum: Int = 0
    var empty: Int = 0

    constructor(floorNum: Int) {
        this.floorNum = floorNum
        this.slots = ArrayList(slotSize)
        for (i in 0..(slotSize - 1)) {
            if (i % 2 == 0) {
                slots.add(Slots(("A" + this.floorNum + (i + 1)), false))
            } else {
                slots.add(Slots(("B" + this.floorNum + (i + 1)), false))
            }
        }
    }

    fun getEmptySlots(): Int {
        for (slot in slots) {
            if (!slot.isFull()) {
                empty++
            }
        }
        return empty
    }

    fun getSlotsList(): ArrayList<Slots> {
        return slots
    }

}