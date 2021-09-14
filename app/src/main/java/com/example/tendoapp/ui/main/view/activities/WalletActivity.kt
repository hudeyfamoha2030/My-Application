package com.example.tendoapp.ui.main.view.activities

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.content.ContentProviderCompat.requireContext
import androidx.recyclerview.widget.GridLayoutManager
import com.example.tendoapp.R
import com.example.tendoapp.data.model.Category
import com.example.tendoapp.data.model.Transaction
import com.example.tendoapp.ui.main.adapter.MyOrderAdapter
import com.example.tendoapp.ui.main.adapter.MyWalletAdapter
import kotlinx.android.synthetic.main.activity_wallet.*
import kotlinx.android.synthetic.main.activity_wallet.view.*
import kotlinx.android.synthetic.main.fragment_orders.*
import kotlinx.android.synthetic.main.fragment_orders.recyclerViewMyOrders
import java.time.LocalDateTime
import java.util.*

class WalletActivity : AppCompatActivity() {

    private var datalisttransaction = mutableListOf<Transaction>()
    private lateinit var myWalletAdapter: MyWalletAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_wallet)
        showTransactions()
    }

        private fun showTransactions(){

            datalisttransaction.add(Transaction(R.drawable.wallet3, Calendar.getInstance().time,"PENDING",50))
            datalisttransaction.add(Transaction(R.drawable.wallet3, Calendar.getInstance().time,"PENDING",50))
            datalisttransaction.add(Transaction(R.drawable.wallet3, Calendar.getInstance().time,"PENDING",50))


            recyclerMyWallet.layoutManager= GridLayoutManager(this,1)
            myWalletAdapter = MyWalletAdapter(this)
            myWalletAdapter.setDataList(datalisttransaction)
            recyclerMyWallet.adapter = myWalletAdapter

        }
    }