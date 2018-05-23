package com.example.boranorben.parkingfinder.popup

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.DisplayMetrics
import com.example.boranorben.parkingfinder.R
import kotlinx.android.synthetic.main.activity_popup.*
import android.R.attr.name
import android.view.View
import android.widget.EditText



class PopupActivity : AppCompatActivity(), PopupView {
    lateinit var presenter: PopupPresenter
    var exTime: String = ""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_popup)
        presenter = PopupPresenter(this)

        val dm: DisplayMetrics = DisplayMetrics()
        windowManager.defaultDisplay.getMetrics(dm)

        var width: Int = dm.widthPixels
        var height: Int = dm.heightPixels

        window.setLayout((width*.8).toInt(), (height*.6).toInt())
    }

    fun calBtnClicked(view: View) {
        presenter.onCalBtnClicked()
    }

    override fun calcuate() {
        exTime = timeField.text.toString()
        estimatedFare.text = "Your estimated parking fare is " + presenter.calculate(exTime).toString() + " Baht"
    }

}
