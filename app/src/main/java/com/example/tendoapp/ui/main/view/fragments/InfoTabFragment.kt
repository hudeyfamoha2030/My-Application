package com.example.tendoapp.ui.main.view.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.example.tendoapp.R
import com.example.tendoapp.databinding.FragmentInfoTabBinding

class InfoTabFragment : Fragment() {

    lateinit var binding: FragmentInfoTabBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding= DataBindingUtil.inflate(inflater, R.layout.fragment_info_tab, container, false)
        return binding.root
    }

}