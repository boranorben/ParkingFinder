package com.example.boranorben.parkingfinder.popup

import java.text.SimpleDateFormat
import java.util.*

class PopupPresenter(val view: PopupView) {
    private var popUp: Popup = Popup()

    fun onCalBtnClicked() {
        view.calcuate()
    }

    fun calculate(eTime: String): Int {
        return popUp.calculate(eTime)
    }

}