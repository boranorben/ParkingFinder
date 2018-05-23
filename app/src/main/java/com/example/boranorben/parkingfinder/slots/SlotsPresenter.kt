package com.example.boranorben.parkingfinder.slots

class SlotsPresenter(val view: SlotsView) {
    private lateinit var slot: Slots

    fun start() {
        view.addTextView()
        view.display()
        view.addSlotsList()
        view.displayStatus()
    }

    fun onParkedBtnClick() {
        view.openPopup()
    }

}