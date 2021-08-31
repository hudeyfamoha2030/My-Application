package com.example.tendoapp.ui.main.view.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import androidx.core.content.ContextCompat
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2
import com.example.tendoapp.R
import com.example.tendoapp.databinding.ActivityProductBinding
import com.example.tendoapp.ui.main.adapter.ViewPagerImageAdapter
import com.example.tendoapp.ui.main.adapter.ViewPagerWithTabLayout
import com.google.android.material.tabs.TabLayout
import kotlinx.android.synthetic.main.activity_product.*

class ProductActivity : AppCompatActivity() {
    lateinit var binding:ActivityProductBinding
    lateinit var indicatorContainer: LinearLayout
    private var imageList = mutableListOf<Int>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=DataBindingUtil.setContentView(this, R.layout.activity_product)
        supportActionBar?.hide()

        initTabLayout()
        postToList()
        val adapter = ViewPagerImageAdapter(imageList)

        binding.viewPagerShowProducts.adapter=adapter
        binding.viewPagerShowProducts.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                setCurrentIndicator(position)
            }
        })

        (binding.viewPagerShowProducts.getChildAt(0) as RecyclerView).overScrollMode = RecyclerView.OVER_SCROLL_NEVER
        setUpIndicators()
        setCurrentIndicator(0)

    }

    private fun initTabLayout() {
        binding.tabLayout.tabGravity = TabLayout.GRAVITY_FILL
        val viewPagerAdapter= ViewPagerWithTabLayout(supportFragmentManager,applicationContext)

        binding.viewpager.adapter = viewPagerAdapter

        binding.tabLayout.setupWithViewPager(binding.viewpager)

        binding.viewpager.addOnPageChangeListener(TabLayout.TabLayoutOnPageChangeListener(binding.tabLayout))

    }

    private fun setUpIndicators(){
        indicatorContainer=binding.LLViewPagerIndicator
        val indicators= arrayOfNulls<ImageView>(4)
        val layoutParams: LinearLayout.LayoutParams = LinearLayout.LayoutParams(
            ViewGroup.LayoutParams.WRAP_CONTENT,
            ViewGroup.LayoutParams.WRAP_CONTENT
        )
        layoutParams.setMargins(8,0,8,0)

        for(i in indicators.indices){
            indicators[i]= ImageView(this)
            indicators[i]?.let {
                it.setImageDrawable(
                    ContextCompat.getDrawable(
                    this,
                    R.drawable.indicator_inactive_blueoutline
                ))
                it.layoutParams=layoutParams
                indicatorContainer.addView(it)
            }
        }
    }

    private fun setCurrentIndicator(position:Int){
        val childCount=indicatorContainer.childCount
        for(i in 0 until childCount){
            val imageView=indicatorContainer.getChildAt(i) as ImageView
            if(i==position){
                imageView.setImageDrawable(
                    ContextCompat.getDrawable(
                        this,
                        R.drawable.indicator_active_blue
                    )
                )
            }
            else{
                imageView.setImageDrawable(
                    ContextCompat.getDrawable(
                        this,
                        R.drawable.indicator_inactive_blueoutline
                    )
                )
            }
        }
    }


    private fun addToList(image: Int){
        imageList.add(image)
    }

    private fun postToList(){
        addToList(R.drawable.tshirt)
        addToList(R.drawable.tisho2)
        addToList(R.drawable.tisho3)
        addToList(R.drawable.tisho4)
    }

}