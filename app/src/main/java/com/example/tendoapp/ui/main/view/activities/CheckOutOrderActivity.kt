package com.example.tendoapp.ui.main.view.activities

import android.os.Bundle
import android.widget.Toast
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.viewpager2.widget.ViewPager2
import com.example.tendoapp.R
import com.example.tendoapp.databinding.ActivityCheckOutOrderBinding
import com.example.tendoapp.ui.main.adapter.RecyclerViewAdapter
import com.example.tendoapp.ui.main.adapter.ViewPagerAdapter
import com.example.tendoapp.ui.main.view.fragments.CartFragment
import com.example.tendoapp.ui.main.view.fragments.OrderConfirmFragment
import com.example.tendoapp.ui.main.view.fragments.OrderCustomerFragment
import com.example.tendoapp.ui.main.view.fragments.OrderMyCartFragment
import com.example.tendoapp.ui.main.view.fragments.screens.OrdersFragment
import com.kofigyan.stateprogressbar.StateProgressBar
import kotlinx.android.synthetic.main.activity_cart_order.*
import kotlinx.coroutines.flow.callbackFlow

class CheckOutOrderActivity : AppCompatActivity() {

    private lateinit var binding: ActivityCheckOutOrderBinding
    var descriptionData = arrayOf("My Cart", "Add customer", "Confirm")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityCheckOutOrderBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbar)


        val fragmentList = arrayListOf<Fragment>(
            OrderMyCartFragment(),
            OrderCustomerFragment(),
            OrderConfirmFragment()
        )
        val adapter = ViewPagerAdapter(
            fm = this.supportFragmentManager,
            fragmentList = fragmentList,
            lifecycle = lifecycle
        )
        binding.stepProgress.setStateDescriptionData(descriptionData)
        binding.stepProgress.setStateDescriptionTypeface("fonts/RobotoSlab-Light.ttf");
        binding.stepProgress.setStateNumberTypeface("fonts/Questrial-Regular.ttf");
        binding.viewpager.adapter = adapter
        var viewpagerCallback = object : ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
//                Toast.makeText(
//                    binding.viewpager.context, "Selected position: ${position}",
//                    Toast.LENGTH_SHORT
//                ).show()
                when (position) {
                    0 -> {
                        return binding.stepProgress.setCurrentStateNumber(StateProgressBar.StateNumber.ONE)
                    }
                    1 -> {
                        return binding.stepProgress.setCurrentStateNumber(StateProgressBar.StateNumber.TWO)
                    }
                    2 -> {
                        return binding.stepProgress.setCurrentStateNumber(StateProgressBar.StateNumber.THREE)
                    }
                }
            }
        }
//            binding.viewpager.setUserInputEnabled(true);
            binding.viewpager.registerOnPageChangeCallback(viewpagerCallback)
        }




}

