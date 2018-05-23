package com.example.boranorben.parkingfinder.popup

import java.text.SimpleDateFormat
import java.util.*

class Popup {
    val currentTime: Date = Calendar.getInstance().time

    fun getTime(): String {
        val sdf: SimpleDateFormat = SimpleDateFormat("HH:mm:ss")
        val formattedTime = sdf.format(Date())
        val time = formattedTime.toString()
        return time
    }

    fun calculate(eTime: String): Int {
        if (eTime != null) {
            var aH: Int = Integer.parseInt("" + getTime().subSequence(0,2))
            var eH: Int = Integer.parseInt("" + eTime.subSequence(0,2))
            var aM: Int = Integer.parseInt("" + getTime().subSequence(3,5))
            var eM: Int = Integer.parseInt("" + eTime.subSequence(3,5))
            if (aM > eM) {
                return ((eH - aH) + 1) * 10
            } else return (eH - aH)*10
        }
        return 0
    }
}