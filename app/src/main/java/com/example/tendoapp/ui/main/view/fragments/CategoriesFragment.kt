package com.example.tendoapp.ui.main.view.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.GridLayoutManager
import com.example.tendoapp.R
import com.example.tendoapp.data.model.Category
import com.example.tendoapp.databinding.FragmentCategoriesBinding
import com.example.tendoapp.databinding.FragmentInfoTabBinding
import com.example.tendoapp.ui.main.adapter.CategoriesAdapter
import com.example.tendoapp.ui.main.adapter.CategoriesAdapterHome
import com.example.tendoapp.ui.main.adapter.CategoriesAdapterMain

class  CategoriesFragment : Fragment() {

    lateinit var binding: FragmentCategoriesBinding
    private var dataListCategory = mutableListOf<Category>()
    private lateinit var categoriesAdapterHome: CategoriesAdapterHome
    private lateinit var categoriesAdapterMain: CategoriesAdapterMain

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding= DataBindingUtil.inflate(inflater, R.layout.fragment_categories, container, false)


        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        showTopCategories()

        showTopCategoriesWomen()

    }

    override fun onStart() {
        super.onStart()
        showTopCategories()

        showTopCategoriesWomen()
    }


    private fun showTopCategories(){

        dataListCategory.add(Category(1,"Man work equipments", R.drawable.ic_category_man_work_equipment))
        dataListCategory.add(Category(1,"Man pants", R.drawable.ic_category_man_pants))
        dataListCategory.add(Category(1,"Man shirts", R.drawable.ic_category_man_shirt))
        dataListCategory.add(Category(1,"Man shoes", R.drawable.ic_category_man_shoes))
        dataListCategory.add(Category(1,"Underwear", R.drawable.ic_category_man_underwear))

        binding.recyclerviewCategoriesHome.layoutManager= GridLayoutManager(context,1)
        categoriesAdapterMain = CategoriesAdapterMain(requireContext())
        categoriesAdapterMain.setDataList(dataListCategory)

        binding.recyclerviewCategoriesHome.adapter = categoriesAdapterMain

    }
    private fun showTopCategoriesWomen(){

        dataListCategory.add(Category(1,"Bags", R.drawable.ic_category_woman_bag))
        dataListCategory.add(Category(1,"Woman pants", R.drawable.ic_category_woman_pants))
        dataListCategory.add(Category(1,"Shoes", R.drawable.ic_category_woman_shoes))
        dataListCategory.add(Category(1,"Dresses", R.drawable.ic_category_dress))
        dataListCategory.add(Category(1,"Woman pants", R.drawable.ic_category_woman_pants))
        dataListCategory.add(Category(1,"Shoes", R.drawable.ic_category_bikini))
        dataListCategory.add(Category(1,"Dresses", R.drawable.ic_category_dress))

        binding.recyclerviewCategoriesHomeWomen.layoutManager= GridLayoutManager(context,3)
        categoriesAdapterHome = CategoriesAdapterHome(requireContext())
        categoriesAdapterHome.setDataList(dataListCategory)

        binding.recyclerviewCategoriesHomeWomen.adapter = categoriesAdapterHome

    }



}