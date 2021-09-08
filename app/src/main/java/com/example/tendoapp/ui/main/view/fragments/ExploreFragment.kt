package com.example.tendoapp.ui.main.view.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.tendoapp.R
import com.example.tendoapp.data.model.Category
import com.example.tendoapp.data.model.Data
import com.example.tendoapp.data.model.Product
import com.example.tendoapp.databinding.FragmentExploreBinding
import com.example.tendoapp.ui.main.adapter.RecyclerViewAdapter

class ExploreFragment : Fragment() {

    private lateinit var recyclerView: RecyclerView
    lateinit var binding: FragmentExploreBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_explore, container, false)

        val dataList = ArrayList<Data>()

        val categoryList = ArrayList<Category>()
        var productsList1= ArrayList<Product>()

        productsList1.add(Product("Timberland", "200", R.drawable.tisho3))
        productsList1.add(Product("Airforce", "80", R.drawable.tisho3))
        productsList1.add(Product("Airmax", "100", R.drawable.tisho3))
        productsList1.add(Product("Supra", "2", R.drawable.tisho3))

        categoryList.add(Category(1,"Shoes",R.drawable.tisho2,productsList1))
        categoryList.add(Category(2,"Women favorites",R.drawable.tisho,productsList1))


//
//        dataList.add(Data(RecyclerViewAdapter.VIEW_TYPE_ONE, "Trending"))
//        dataList.add(Data(RecyclerViewAdapter.VIEW_TYPE_TWO, "Trousers"))
//        dataList.add(Data(RecyclerViewAdapter.VIEW_TYPE_ONE, "Shops for you"))
//        dataList.add(Data(RecyclerViewAdapter.VIEW_TYPE_TWO, "Favorites"))


        recyclerView = binding.recyclerViewExplore

        val adapter = RecyclerViewAdapter(requireContext(), categoryList)
        recyclerView.layoutManager = LinearLayoutManager(context)
        recyclerView.adapter = adapter

        return binding.root

    }
}