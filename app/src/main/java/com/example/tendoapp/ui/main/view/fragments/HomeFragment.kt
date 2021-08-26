package com.example.tendoapp.ui.main.view.fragments

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import android.widget.ImageView
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.example.tendoapp.ui.main.adapter.ProductsAdapter
import com.example.tendoapp.R
import com.example.tendoapp.data.model.Category
import com.example.tendoapp.data.model.Product
import com.example.tendoapp.databinding.FragmentHomeBinding
import com.example.tendoapp.ui.main.adapter.CategoriesAdapter
import kotlinx.android.synthetic.main.fragment_home.*

class HomeFragment : Fragment() {

    private lateinit var productsAdapter: ProductsAdapter
    private lateinit var categoriesAdapter: CategoriesAdapter
    private var dataList = mutableListOf<Product>()
    private var dataListCategory = mutableListOf<Category>()

    lateinit var binding:FragmentHomeBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding= DataBindingUtil.inflate(inflater, R.layout.fragment_home, container, false)
        searchViewListener()

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
    private fun flipperImages(image:Int){
        val imageView= ImageView(requireContext())
        imageView.setBackgroundResource(image)

        binding.viewFlipper.addView(imageView)
        binding.viewFlipper.flipInterval=4000  //4sec
        binding.viewFlipper.isAutoStart=true

        //some animations

        binding.viewFlipper.setInAnimation(requireContext(),android.R.anim.slide_in_left)
        binding.viewFlipper.setOutAnimation(requireContext(),android.R.anim.slide_out_right)


    }

    override fun onResume() {
        super.onResume()
        val imagesArray= arrayOf(
            R.drawable.ic_slideshow1,
            R.drawable.ic_slideshow2,
            R.drawable.ic_slideshow3
        )

        for(image in imagesArray){    // we have put this in OnResume because it is also called during onCreate
            flipperImages(image)
        }
    }

    fun searchViewListener(){
        binding.LLSearchView.setOnClickListener {
            findNavController().navigate(R.id.action_homeFragment_to_searchFragment)
        }
    }


}