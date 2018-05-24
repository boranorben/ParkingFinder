package com.example.boranorben.parkingfinder.slots

import android.os.Parcel
import android.os.Parcelable

class Slots() : Parcelable {

    private var slotId: String = ""
    private var full: Int = 0

    constructor(parcel: Parcel) : this() {
        slotId = parcel.readString()
        full = parcel.readInt()
    }

    constructor(id: String, full: Int) : this() {
        this.slotId = id
        this.full = full
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

    override fun writeToParcel(dest: Parcel?, flags: Int) {
        dest?.writeString(this.slotId)
        dest?.writeInt(this.full)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Slots> {
        override fun createFromParcel(parcel: Parcel): Slots {
            return Slots(parcel)
        }

        override fun newArray(size: Int): Array<Slots?> {
            return newArray(size)
        }
    }
}