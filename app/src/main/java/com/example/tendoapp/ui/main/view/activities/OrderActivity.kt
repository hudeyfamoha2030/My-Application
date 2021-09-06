package com.example.tendoapp.ui.main.view.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.tendoapp.R
import kotlinx.android.synthetic.main.activity_order.*
import kotlinx.android.synthetic.main.activity_profile.*
import kotlinx.android.synthetic.main.activity_profile.Edit_Button

class OrderActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_order)

        //navigate to User activity
        Edit_Order_Button.setOnClickListener {
            val intent = Intent(this, OrderDetailsActivity::class.java)
            startActivity(intent)
        }

        Image_backword.setOnClickListener {
            finish()
        }
    }
}