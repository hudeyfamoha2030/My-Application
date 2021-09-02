package com.example.tendoapp.ui.main.view.fragments

import DepthPageTransformer
import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import androidx.core.content.ContextCompat
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2
import com.example.tendoapp.R
import com.example.tendoapp.databinding.FragmentViewPagerBinding
import com.example.tendoapp.ui.main.adapter.ViewPagerAdapter
import com.example.tendoapp.ui.main.view.fragments.screens.FirstScreenFragment
import com.example.tendoapp.ui.main.view.fragments.screens.SecondScreenFragment
import com.example.tendoapp.ui.main.view.fragments.screens.ThirdScreenFragment

class ViewPagerFragment : Fragment() {

    lateinit var indicatorContainer: LinearLayout
    lateinit var binding:FragmentViewPagerBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding= DataBindingUtil.inflate<FragmentViewPagerBinding>(inflater,R.layout.fragment_view_pager, container, false)

        val fragmentList = arrayListOf<Fragment>(
            FirstScreenFragment(),
            SecondScreenFragment(),
            ThirdScreenFragment()
        )
        val adapter = ViewPagerAdapter(
            fm = requireActivity().supportFragmentManager,
            fragmentList = fragmentList,
            lifecycle = lifecycle
        )

        binding.viewPager.adapter=adapter
        binding.viewPager.setPageTransformer(DepthPageTransformer())

        binding.viewPager.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                setCurrentIndicator(position)
            }
        })

        (binding.viewPager.getChildAt(0) as RecyclerView).overScrollMode = RecyclerView.OVER_SCROLL_NEVER
        setUpIndicators()
        setCurrentIndicator(0)
        skipToNextScreen()



        return binding.root
    }

    private fun skipToNextScreen() {
        if(binding.btnSkip.visibility == View.VISIBLE){
            binding.btnSkip.setOnClickListener {
                findNavController().navigate(R.id.action_viewPagerFragment_to_signUpFragment)
            }
        }
    }

    fun setUpIndicators(){
        indicatorContainer=binding.LLindicatorContainer
        val indicators= arrayOfNulls<ImageView>(3)
        val layoutParams: LinearLayout.LayoutParams = LinearLayout.LayoutParams(
            ViewGroup.LayoutParams.WRAP_CONTENT,
            ViewGroup.LayoutParams.WRAP_CONTENT
        )
        layoutParams.setMargins(8,0,8,0)

        for(i in indicators.indices){
            indicators[i]= ImageView(requireContext())
            indicators[i]?.let {
                it.setImageDrawable(
                    ContextCompat.getDrawable(
                    requireContext(),
                    R.drawable.indicator_inactive_background
                ))
                it.layoutParams=layoutParams
                indicatorContainer.addView(it)
            }
        }
    }

    private fun setCurrentIndicator(position:Int){
        if(position==2){
            binding.btnGetStarted.visibility=View.VISIBLE
            binding.btnSkip.visibility=View.INVISIBLE
//            binding.btnNext.visibility=View.INVISIBLE
            navigateToNextScreen()
        }
        else{
//            binding.btnNext.visibility=View.VISIBLE
            binding.btnSkip.visibility=View.VISIBLE
            binding.btnGetStarted.visibility=View.INVISIBLE
        }
        val childCount=indicatorContainer.childCount
        for(i in 0 until childCount){
            val imageView=indicatorContainer.getChildAt(i) as ImageView
            if(i==position){
                imageView.setImageDrawable(
                    ContextCompat.getDrawable(
                        requireContext(),
                        R.drawable.indicator_active_background
                    )
                )
            }
            else{
                imageView.setImageDrawable(
                    ContextCompat.getDrawable(
                        requireContext(),
                        R.drawable.indicator_inactive_background
                    )
                )
            }
        }
    }

    private fun navigateToNextScreen(){
        if(binding.btnGetStarted.visibility == View.VISIBLE){
            binding.btnGetStarted.setOnClickListener {
                findNavController().navigate(R.id.action_viewPagerFragment_to_signUpFragment)
                onBoardingFinished()
            }
        }
    }

    private fun onBoardingFinished(){
        val sharedPref = requireActivity().getSharedPreferences("onBoarding", Context.MODE_PRIVATE)
        val editor = sharedPref.edit()
        editor.putBoolean("Finished", true)
        editor.apply()
    }

}