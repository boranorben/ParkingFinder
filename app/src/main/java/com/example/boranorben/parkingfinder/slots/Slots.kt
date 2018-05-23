package com.example.boranorben.parkingfinder.slots

class Slots {
    private var slotId: String = ""
    private var full: Int = 0

    constructor(id: String, full: Int) {
        this.slotId = id
        this.full = full
//        println("id: " + this.slotId + " is full?: " + this.full)
    }

    fun isFull(): Boolean {
        if (this.full == 1) {
            return true
        } else {
            false
        }
        return false
    }

    fun setFull() {
        this.full = 1
    }

    fun getFull(): Int {
        return this.full
    }

    fun getId(): String {
        return this.slotId
    }
}