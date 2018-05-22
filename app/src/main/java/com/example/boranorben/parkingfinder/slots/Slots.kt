package com.example.boranorben.parkingfinder.slots

class Slots {
    var slotId: String = ""
    var full: Boolean = false

    constructor(id: String, full: Boolean) {
        this.slotId = id
        this.full = full
//        println("id: " + this.slotId + " is full?: " + this.full)
    }

    fun isFull(): Boolean {
        return this.full
    }

    fun setFull() {
        this.full = true
    }

    fun getId(): String {
        return this.slotId
    }

}