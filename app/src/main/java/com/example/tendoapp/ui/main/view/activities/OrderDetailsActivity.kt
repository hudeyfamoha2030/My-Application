package com.example.tendoapp.ui.main.view.activities

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import com.example.tendoapp.R
import com.example.tendoapp.data.model.Category
import com.example.tendoapp.ui.main.adapter.MyOrderAdapter
import com.kofigyan.stateprogressbar.StateProgressBar
import kotlinx.android.synthetic.main.activity_order_details.*
import kotlinx.android.synthetic.main.activity_user.*
import kotlinx.android.synthetic.main.fragment_orders.*


class OrderDetailsActivity : AppCompatActivity() {

    var descriptionData = arrayOf("Packing", "Shipping", "Arriving", "Success")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_order_details)

        val stateProgressBar =
            findViewById<View>(R.id.step_progress) as StateProgressBar
        stateProgressBar.setStateDescriptionData(descriptionData)

        //navigate to Profile activity
        arrow_back.setOnClickListener {

            onBackPressed()
        }
    }


    }