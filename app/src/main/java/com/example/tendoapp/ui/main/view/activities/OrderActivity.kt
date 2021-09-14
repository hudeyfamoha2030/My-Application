package com.example.tendoapp.ui.main.view.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import com.example.tendoapp.R
import com.example.tendoapp.data.model.Category
import com.example.tendoapp.data.model.Transaction
import com.example.tendoapp.ui.main.adapter.MyOderDetailsAdapter
import com.example.tendoapp.ui.main.adapter.MyOrderAdapter
import kotlinx.android.synthetic.main.activity_order.*
import kotlinx.android.synthetic.main.activity_order_details.*
import kotlinx.android.synthetic.main.activity_profile.*
import kotlinx.android.synthetic.main.activity_profile.Edit_Button
import kotlinx.android.synthetic.main.fragment_orders.*
import java.util.*

class OrderActivity : AppCompatActivity() {

    private var datalisttransaction = mutableListOf<Transaction>()
    private lateinit var myOderDetailsAdapter: MyOderDetailsAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_order)
        showOrderDetails()


        //navigate to User activity
        Edit_Order_Button.setOnClickListener {
            val intent = Intent(this, OrderDetailsActivity::class.java)
            startActivity(intent)
        }

        Image_backword.setOnClickListener {
            finish()
        }
    }

        private fun showOrderDetails(){

            datalisttransaction.add(Transaction(R.drawable.wallet3, Calendar.getInstance().time,"PENDING",50))
            datalisttransaction.add(Transaction(R.drawable.wallet3, Calendar.getInstance().time,"PENDING",50))
            datalisttransaction.add(Transaction(R.drawable.wallet3, Calendar.getInstance().time,"PENDING",50))
            datalisttransaction.add(Transaction(R.drawable.wallet3, Calendar.getInstance().time,"PENDING",50))




            recyclerViewMyOrdersDetails.layoutManager= GridLayoutManager(this,1)
            myOderDetailsAdapter = MyOderDetailsAdapter(this)
            myOderDetailsAdapter.setDataList(datalisttransaction)
            recyclerViewMyOrdersDetails.adapter = myOderDetailsAdapter

        }
    }