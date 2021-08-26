package com.example.tendoapp.ui.main.view.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.findNavController
import com.example.tendoapp.R
import com.example.tendoapp.databinding.FragmentAccountActivationBinding

class AccountActivationFragment : Fragment() {

    lateinit var binding: FragmentAccountActivationBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding=
            DataBindingUtil.inflate(inflater, R.layout.fragment_account_activation, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.btnActivateAccount.setOnClickListener {
            findNavController().navigate(R.id.action_accountActivationFragment_to_mainActivity2)
        }
    }

}