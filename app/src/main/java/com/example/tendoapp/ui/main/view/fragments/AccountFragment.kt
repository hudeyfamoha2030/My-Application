package com.example.tendoapp.ui.main.view.fragments

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.addCallback
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.findNavController
import com.example.tendoapp.R
import com.example.tendoapp.databinding.FragmentAccountBinding
import com.example.tendoapp.ui.main.view.activities.OrderActivity
import com.example.tendoapp.ui.main.view.activities.ProfileActivity
import com.example.tendoapp.ui.main.view.activities.WalletActivity
import kotlinx.android.synthetic.main.fragment_account.*

class AccountFragment : Fragment() {
    lateinit var binding: FragmentAccountBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        // This callback will only be called when MyFragment is at least Started.


        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_account, container, false)

        binding.tvProfile.setOnClickListener {
            this.startActivity(Intent(context,ProfileActivity::class.java))

        }
        binding.tvOrders.setOnClickListener {
            this.startActivity(Intent(context,OrderActivity::class.java))

        }

        binding.tvWallet.setOnClickListener {
            this.startActivity(Intent(context,WalletActivity::class.java))

        }
        return binding.root
    }

}