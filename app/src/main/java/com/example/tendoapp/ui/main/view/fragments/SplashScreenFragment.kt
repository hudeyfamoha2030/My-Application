package com.example.tendoapp.ui.main.view.fragments

import android.content.Context
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.findNavController
import com.example.tendoapp.R
import com.example.tendoapp.databinding.FragmentSplashScreenBinding
import android.os.HandlerThread
import kotlinx.coroutines.*


class SplashScreenFragment : Fragment() {

    lateinit var binding:FragmentSplashScreenBinding
    val activityScope = CoroutineScope(Dispatchers.Main)

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {






        binding= DataBindingUtil.inflate(inflater, R.layout.fragment_splash_screen, container, false)

        return binding.root
    }

    private fun onBoardingFinished(): Boolean{
        val sharedPref = requireActivity().getSharedPreferences("onBoarding", Context.MODE_PRIVATE)
        return sharedPref.getBoolean("Finished", false)
    }

    override fun onPause() {
        super.onPause()
    }

    override fun onStart() {
        super.onStart()
        activityScope.launch {
            delay(2000)
            findNavController().navigate(R.id.action_splashScreenFragment_to_viewPagerFragment)
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        activityScope.cancel()
    }

    override fun onResume() {
        super.onResume()

    }

}