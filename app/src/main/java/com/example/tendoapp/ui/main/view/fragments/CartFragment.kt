package com.example.tendoapp.ui.main.view.fragments

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import com.example.tendoapp.R
import com.example.tendoapp.data.model.Category
import com.example.tendoapp.ui.main.adapter.CategoriesAdapterHome
import com.example.tendoapp.ui.main.adapter.MyCartAdapter
import com.example.tendoapp.ui.main.view.activities.CheckOutOrderActivity
import com.example.tendoapp.ui.main.view.activities.OrderDetailsActivity
import com.example.tendoapp.ui.main.view.activities.ProfileActivity
import kotlinx.android.synthetic.main.fragment_cart.*
import kotlinx.android.synthetic.main.fragment_categories.*
import kotlinx.android.synthetic.main.fragment_categories.recyclerviewCategoriesHome

class CartFragment : Fragment() {
    private var dataListCategory = mutableListOf<Category>()
    private lateinit var myCartAdapter: MyCartAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_cart, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        showTopCategories()
        btn_create_order.setOnClickListener{
            val intent = Intent(context, CheckOutOrderActivity::class.java)
            startActivity(intent)
        }
    }
    private fun showTopCategories(){

        dataListCategory.add(Category(0,"Man work equipments", R.drawable.tisho3))
        dataListCategory.add(Category(1,"Man pants", R.drawable.tshirt))
        dataListCategory.add(Category(1,"Man shirts", R.drawable.tisho2))


        recyclerViewMyCart.layoutManager= GridLayoutManager(context,1)
        myCartAdapter = MyCartAdapter(requireContext())
        myCartAdapter.setDataList(dataListCategory)
        recyclerViewMyCart.adapter = myCartAdapter

    }
}