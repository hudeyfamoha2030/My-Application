package com.example.tendoapp

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
import com.example.tendoapp.databinding.FragmentSplashScreenBinding

class SplashScreenFragment : Fragment() {

    lateinit var binding:FragmentSplashScreenBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        Handler(Looper.getMainLooper()).postDelayed(
            {
                if (onBoardingFinished()){
                    findNavController().navigate(R.id.action_splashScreenFragment_to_signUpFragment)
                }else{
                    findNavController().navigate(R.id.action_splashScreenFragment_to_viewPagerFragment)
                }
            },
            1500
        )

        binding= DataBindingUtil.inflate(inflater,R.layout.fragment_splash_screen, container, false)

        return binding.root
    }

    private fun onBoardingFinished(): Boolean{
        val sharedPref = requireActivity().getSharedPreferences("onBoarding", Context.MODE_PRIVATE)
        return sharedPref.getBoolean("Finished", false)
    }
}