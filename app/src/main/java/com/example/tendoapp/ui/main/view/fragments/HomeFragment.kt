package com.example.tendoapp.ui.main.view.fragments

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.Log
import android.view.*
import androidx.fragment.app.Fragment
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.Toast
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.ContextCompat
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.CompositePageTransformer
import androidx.viewpager2.widget.MarginPageTransformer
import androidx.viewpager2.widget.ViewPager2
import com.example.tendoapp.ui.main.adapter.ProductsAdapter
import com.example.tendoapp.R
import com.example.tendoapp.data.model.Category
import com.example.tendoapp.data.model.Product
import com.example.tendoapp.data.model.SliderItem
import com.example.tendoapp.databinding.FragmentHomeBinding
import com.example.tendoapp.ui.main.adapter.CategoriesAdapter
import com.example.tendoapp.ui.main.adapter.ImageSliderAdapter
import com.google.android.material.bottomsheet.BottomSheetBehavior
import kotlinx.android.synthetic.main.fragment_home.*
import kotlin.math.abs

class HomeFragment : Fragment() {

    private lateinit var productsAdapter: ProductsAdapter
    lateinit var indicatorContainer: LinearLayout
    private lateinit var categoriesAdapter: CategoriesAdapter
    private var dataList = mutableListOf<Product>()
    private var dataListCategory = mutableListOf<Category>()
    var str:String=""

    lateinit var sliderItemList:ArrayList<SliderItem>
    lateinit var sliderAdapter: ImageSliderAdapter
    lateinit var sliderHandler: Handler
    lateinit var sliderRunnable:Runnable

    lateinit var binding:FragmentHomeBinding
    val TAG="HomeFragment"


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding= DataBindingUtil.inflate(inflater, R.layout.fragment_home, container, false)
        searchViewListener()
        setUpIndicators()
        setCurrentIndicator(0)
        sliderItems()
        itemSliderView()

        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        showTopCategories();
        showAllProducts();
        super.onViewCreated(view, savedInstanceState)
    }


    private fun showTopCategories(){

        dataListCategory.add(Category("Technology", R.drawable.ic_tech))
        dataListCategory.add(Category("Pharmacy", R.drawable.ic_pharmacy))
        dataListCategory.add(Category("Agriculture", R.drawable.ic_agri))
        dataListCategory.add(Category("Accessories", R.drawable.ic_acess))

        binding.recyclerviewCategories.layoutManager= GridLayoutManager(context,2)
        categoriesAdapter = CategoriesAdapter(requireContext())
        categoriesAdapter.setDataList(dataListCategory)

        binding.recyclerviewCategories.adapter = categoriesAdapter

    }
    private fun showAllProducts(){

        dataList.add(Product("T-shirt", "₵67.90", R.drawable.tisho))
        dataList.add(Product("T-shirt", "₵67.90", R.drawable.tisho2))
        dataList.add(Product("T-shirt", "₵67.90", R.drawable.tisho3))
        dataList.add(Product("T-shirt", "₵67.90", R.drawable.tisho4))
        dataList.add(Product("T-shirt", "₵67.90", R.drawable.tisho))
        dataList.add(Product("T-shirt", "₵67.90", R.drawable.tisho2))
        dataList.add(Product("T-shirt", "₵67.90", R.drawable.tisho3))
        dataList.add(Product("T-shirt", "₵67.90", R.drawable.tisho4))

        val recyclerViewProducts=binding.recyclerviewProducts

        recyclerViewProducts.layoutManager= GridLayoutManager(context,2)
        productsAdapter = ProductsAdapter(requireContext())
        productsAdapter.setDataList(dataList)
        recyclerViewProducts.adapter = productsAdapter

        recyclerviewProducts.setRecyclerListener {

        }
    }

    private fun itemSliderView() {
        sliderItemList.add(SliderItem(R.drawable.ic_slideshow1))
        sliderItemList.add(SliderItem(R.drawable.ic_slideshow2))
        sliderItemList.add(SliderItem(R.drawable.ic_slideshow3))
    }

    private fun sliderItems() {
        sliderItemList= ArrayList()
        sliderAdapter= ImageSliderAdapter(binding.viewpager22,sliderItemList)
        binding.viewpager22.adapter=sliderAdapter
        binding.viewpager22.clipToPadding=false
        binding.viewpager22.clipChildren=false
        binding.viewpager22.offscreenPageLimit=3
        binding.viewpager22.getChildAt(0).overScrollMode= RecyclerView.OVER_SCROLL_NEVER
        val compositePageTransformer= CompositePageTransformer()
        compositePageTransformer.addTransformer(MarginPageTransformer(35))
        compositePageTransformer.addTransformer { page, position ->
            val r=1- abs(position)
            page.scaleY=0.85f + r*0.15f
        }
        binding.viewpager22.setPageTransformer(compositePageTransformer)
        sliderHandler= Handler(Looper.getMainLooper())
        sliderRunnable= Runnable {
            binding.viewpager22.currentItem=binding.viewpager22.currentItem + 1
        }
        str="First"
        binding.viewpager22.registerOnPageChangeCallback(object :
            ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                Log.d(TAG,position.toString())

                if (position==0 || position%3==0)
                {
                    str="Second"
                    setCurrentIndicator(0)
                }
                else{
                    if(str == "Second"){
                        str="Third"
                        setCurrentIndicator(1)
                    }
                    else{
                        setCurrentIndicator(2)
                    }

                }

                sliderHandler.removeCallbacks(sliderRunnable)
                sliderHandler.postDelayed(sliderRunnable,4000)
            }
        }
        )
    }

    override fun onPause() {
        super.onPause()
        sliderHandler.removeCallbacks(sliderRunnable)
    }

    override fun onResume() {
        super.onResume()
        sliderHandler.postDelayed(sliderRunnable,4000)
    }

    private fun searchViewListener(){
        binding.LLSearchView.setOnClickListener {
            findNavController().navigate(R.id.action_homeFragment_to_searchFragment)
        }
    }

    private fun setUpIndicators(){
        indicatorContainer=binding.LLViewPagerIndicator
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
                        requireContext(),
                        R.drawable.indicator_active_blue
                    )
                )
            }
            else{
                imageView.setImageDrawable(
                    ContextCompat.getDrawable(
                        requireContext(),
                        R.drawable.indicator_inactive_blueoutline
                    )
                )
            }
        }
    }



}