package com.example.tendoapp.ui.main.view.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import com.example.tendoapp.R
import com.example.tendoapp.data.model.Category
import com.example.tendoapp.ui.main.adapter.MyCartAdapter
import com.example.tendoapp.ui.main.adapter.MySharesAdapter
import kotlinx.android.synthetic.main.fragment_cart.*
import kotlinx.android.synthetic.main.fragment_shares.*

class SharesFragment : Fragment() {

    lateinit var mySharesAdapter: MySharesAdapter
    private var dataListCategory = mutableListOf<Category>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_shares, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
//        showTopCategories()
    }
    private fun showTopCategories(){

        dataListCategory.add(Category(1,"Man work equipments", R.drawable.tisho3))
        dataListCategory.add(Category(0,"Man pants", R.drawable.tshirt))
        dataListCategory.add(Category(1,"Man shirts", R.drawable.tisho2))


//        recyclerViewMyShares.layoutManager= GridLayoutManager(context,1)
//        mySharesAdapter = MySharesAdapter(requireContext())
//        mySharesAdapter.setDataList(dataListCategory)
//        recyclerViewMyShares.adapter = mySharesAdapter

    }
}