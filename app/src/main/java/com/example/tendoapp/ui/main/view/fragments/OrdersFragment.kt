package com.example.tendoapp.ui.main.view.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import com.example.tendoapp.R
import com.example.tendoapp.data.model.Category
import com.example.tendoapp.data.model.Product
import com.example.tendoapp.ui.main.adapter.MyCartAdapter
import com.example.tendoapp.ui.main.adapter.MyOrderAdapter
import kotlinx.android.synthetic.main.fragment_cart.*
import kotlinx.android.synthetic.main.fragment_cart.recyclerViewMyCart
import kotlinx.android.synthetic.main.fragment_orders.*

class OrdersFragment : Fragment() {
    private var dataListCategory = mutableListOf<Category>()
    private lateinit var myOrderAdapter: MyOrderAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_orders, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        showTopCategories()
    }
    private fun showTopCategories(){

        dataListCategory.add(Category(1,"Man work equipments", R.drawable.tisho3))
        dataListCategory.add(Category(0,"Man pants", R.drawable.tshirt))
        dataListCategory.add(Category(1,"Man shirts", R.drawable.tisho2))


        recyclerViewMyOrders.layoutManager= GridLayoutManager(context,1)
        myOrderAdapter = MyOrderAdapter(requireContext())
        myOrderAdapter.setDataList(dataListCategory)
        recyclerViewMyOrders.adapter = myOrderAdapter

    }

}