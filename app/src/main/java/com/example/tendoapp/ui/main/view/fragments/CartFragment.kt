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

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [CartFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class CartFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    private var dataListCategory = mutableListOf<Category>()
    private lateinit var myCartAdapter: MyCartAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_cart, container, false)
    }


    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment CartFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            CartFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
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