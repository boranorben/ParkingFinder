package com.example.boranorben.parkingfinder.floor

import android.os.Parcel
import android.os.Parcelable
import com.example.boranorben.parkingfinder.slots.Slots

class Floor() : Parcelable {
    private var slotSize: Int = 8
    private var slots = ArrayList<Slots>()
    private var floorNum: Int = 0
    private var empty: Int = 0

    constructor(floorNum: Int) : this() {
        this.floorNum = floorNum
        for (i in 0..slotSize - 1) {
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

    fun getAllSlots(): ArrayList<Slots> {
        return this.slots
    }

    constructor(parcel: Parcel) : this() {
        slotSize = parcel.readInt()
        floorNum = parcel.readInt()
        empty = parcel.readInt()
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(slotSize)
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
            return arrayOfNulls(size)
        }
    }
}