package com.example.tendoapp.ui.main.view.activities

import android.os.Bundle
import com.google.android.material.tabs.TabLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.tendoapp.databinding.ActivityCartOrderBinding
import com.example.tendoapp.ui.main.adapter.ViewPagerAdapter
import com.example.tendoapp.ui.main.view.fragments.CartFragment
import com.example.tendoapp.ui.main.view.fragments.OrdersFragment
import com.google.android.material.tabs.TabLayoutMediator
import kotlinx.android.synthetic.main.activity_cart_order.*

class CartOrderActivity : AppCompatActivity() {

    private lateinit var binding: ActivityCartOrderBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityCartOrderBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val fragmentList = arrayListOf<Fragment>(
            CartFragment(),
            OrdersFragment(),
        )
        val adapter = ViewPagerAdapter(
            fm = this.supportFragmentManager,
            fragmentList = fragmentList,
            lifecycle = lifecycle
        )


        supportActionBar?.setHomeButtonEnabled(true)
        supportActionBar?.show()
        toolbar.setNavigationOnClickListener{
            onBackPressed()
        }


        binding.viewPager.adapter = adapter
        val tabs: TabLayout = binding.tabs

        TabLayoutMediator(tabs, viewPager) { tab, position ->
            if(position==0) tab.text="My Cart"
            if(position==1) tab.text="My Orders"
        }.attach()
//        tabs.setupWithViewPager(viewPager)
//        val fab: FloatingActionButton = binding.fab

//        fab.setOnClickListener { view ->
//            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                .setAction("Action", null).show()
//        }
    }
}