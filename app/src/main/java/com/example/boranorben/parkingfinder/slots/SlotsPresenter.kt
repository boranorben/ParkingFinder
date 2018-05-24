package com.example.boranorben.parkingfinder.slots

class SlotsPresenter(val view: SlotsView) {

    fun start() {
        view.addTextView()
        view.display()
        view.displayStatus()
    }

    fun onParkedBtnClicked() {
        view.openPopup()
    }

}