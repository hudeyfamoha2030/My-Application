package com.example.tendoapp.ui.main.view.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.addCallback
import com.example.tendoapp.R

class AccountFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        // This callback will only be called when MyFragment is at least Started.

        val callback = requireActivity().onBackPressedDispatcher.addCallback(this) {

            // Handle the back button event
        }

        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_account, container, false)

    }

}