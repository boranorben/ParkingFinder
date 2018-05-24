package com.example.boranorben.parkingfinder.floor

import android.os.Parcel
import android.os.Parcelable
import com.example.boranorben.parkingfinder.slots.Slots

class Floor() : Parcelable {
    private var slotSize: Int = 8
    private var slots: ArrayList<Slots> = ArrayList()
    private var floorNum: Int = 0
    private var empty: Int = 0

    constructor(floorNum: Int) : this() {
        this.floorNum = floorNum
        var j: Int = 1
        var k: Int = 1
        for (i in 1..slotSize) {
            if (i < 5) {
                slots.add(Slots(("A" + this.floorNum + j++), 0))
            } else {
                slots.add(Slots(("B" + this.floorNum + k++), 0))
            }
        }
    }

    fun getEmptySlots(): Int {
        empty = 0
        for (slot in slots) {
            if (!slot.isFull()) {
                empty++
            }
        }
        return empty
    }

    fun getAllSlots(): ArrayList<Slots> {
        return this.slots
    }

    constructor(parcel: Parcel) : this() {
        slotSize = parcel.readInt()
        parcel.readTypedList(slots, Slots.CREATOR)
        floorNum = parcel.readInt()
        empty = parcel.readInt()
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(slotSize)
        parcel.writeTypedList(slots)
        parcel.writeInt(floorNum)
        parcel.writeInt(empty)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Floor> {
        override fun createFromParcel(parcel: Parcel): Floor {
            return Floor(parcel)
        }

        override fun newArray(size: Int): Array<Floor?> {
            return newArray(size)
        }
    }
}