package com.example.tendoapp.ui.main.view.fragments

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.tendoapp.R
import com.example.tendoapp.data.model.Category
import com.example.tendoapp.databinding.FragmentCategoriesBinding
import com.example.tendoapp.databinding.FragmentInfoTabBinding
import com.example.tendoapp.ui.main.adapter.CategoriesAdapter
import com.example.tendoapp.ui.main.adapter.CategoriesAdapterHome
import com.example.tendoapp.ui.main.adapter.CategoriesAdapterMain
import com.example.tendoapp.ui.main.adapter.ParentAdapter
import com.example.tendoapp.utils.objects.ParentDataFactory
import kotlinx.android.synthetic.main.fragment_categories.*

class  CategoriesFragment : Fragment() {

    lateinit var recyclerView: RecyclerView
    lateinit var binding: FragmentCategoriesBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding= DataBindingUtil.inflate(inflater, R.layout.fragment_categories, container, false)

        initRecycler()

        return binding.root
    }
    @SuppressLint("WrongConstant")

    private fun initRecycler(){
        recyclerView = rv_parent

        recyclerView.apply {
            layoutManager = LinearLayoutManager(requireContext(),
                LinearLayout.VERTICAL, false)
            adapter = ParentAdapter(
                ParentDataFactory
                .getParents(5))
        }

    }


    }