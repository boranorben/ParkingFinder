package com.example.boranorben.parkingfinder.slots

import android.os.Parcel
import android.os.Parcelable

class Slots() : Parcelable {
    var slotId: String = ""
    var full: Boolean = false

    constructor(id: String, full: Boolean) : this() {
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

    constructor(parcel: Parcel) : this() {
        slotId = parcel.readString()
        full = parcel.readByte() != 0.toByte()
    }

    companion object CREATOR : Parcelable.Creator<Slots> {
        override fun createFromParcel(parcel: Parcel): Slots {
            return Slots(parcel)
        }

        override fun newArray(size: Int): Array<Slots?> {
            return arrayOfNulls(size)
        }
    }

    override fun writeToParcel(dest: Parcel?, flags: Int) {
        dest?.writeString(this.slotId)
        dest?.writeByte((if (this.full) 1 else 0).toByte());
    }

    override fun describeContents(): Int {
        return 0
    }


}