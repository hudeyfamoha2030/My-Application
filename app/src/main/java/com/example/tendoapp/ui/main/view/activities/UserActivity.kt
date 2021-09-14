package com.example.tendoapp.ui.main.view.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import com.example.tendoapp.R
import com.example.tendoapp.data.model.Transaction
import com.example.tendoapp.ui.main.adapter.MyUserAdapter
import com.example.tendoapp.ui.main.adapter.MyWalletAdapter
import kotlinx.android.synthetic.main.activity_profile.*
import kotlinx.android.synthetic.main.activity_user.*
import kotlinx.android.synthetic.main.activity_wallet.*
import java.util.*

class UserActivity : AppCompatActivity() {

    private var datalisttransaction = mutableListOf<Transaction>()
    private lateinit var myUserAdapter: MyUserAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user)
        showUserProfile()

        //navigate to Profile activity
        image_back.setOnClickListener {
            val intent = Intent(this, ProfileActivity::class.java)
            startActivity(intent)
        }
    }

        private fun showUserProfile(){

            datalisttransaction.add(Transaction(R.drawable.wallet3, Calendar.getInstance().time,"PENDING",50))


            recyclerUser.layoutManager= GridLayoutManager(this,1)
            myUserAdapter = MyUserAdapter(this)
            myUserAdapter.setDataList(datalisttransaction)
            recyclerUser.adapter = myUserAdapter

        }
    }