package com.example.tendoapp.ui.main.view.activities

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.tendoapp.R
import com.kofigyan.stateprogressbar.StateProgressBar


class OrderDetailsActivity : AppCompatActivity() {

    var descriptionData = arrayOf("Packing", "Shipping", "Arriving", "Success")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_order_details)

        val stateProgressBar =
            findViewById<View>(R.id.step_progress) as StateProgressBar
        stateProgressBar.setStateDescriptionData(descriptionData)

    }
}