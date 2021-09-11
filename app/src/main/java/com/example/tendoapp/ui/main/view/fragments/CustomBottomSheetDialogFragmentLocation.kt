package com.example.tendoapp.ui.main.view.fragments

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SearchView
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import com.example.tendoapp.R
import com.example.tendoapp.data.model.Location
import com.example.tendoapp.ui.main.adapter.LocationAdapter
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import kotlinx.android.synthetic.main.layout_location_item_bottom_sheet.*
import kotlinx.android.synthetic.main.layout_share_item_bottom_sheet.*
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.tendoapp.ui.main.view.`interface`.BottomSheetInterface


/**
 * Created by goodlife on 03,September,2021
 */
class CustomBottomSheetDialogFragmentLocation : BottomSheetDialogFragment() {

    private var locations: ArrayList<Location> = arrayListOf()
    private var matchedLocations: ArrayList<Location> = arrayListOf()
    private lateinit var locationAdapter: LocationAdapter


    companion object {

        const val TAG = "CustomBottomSheetDialogFragmentLocation"

    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.layout_location_item_bottom_sheet, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        initRecyclerView()
        performSearch()

    }

    private fun initRecyclerView() {

        locations = arrayListOf(
            Location("Central Accra", 19),
            Location("Adenta", 19),
            Location("Kasoa", 21),
            Location("Kumasi", 19),
            Location("Cape Coast", 35),
            Location("Takoradi ", 23),
            Location("Tamale", 17),
            Location("Madina", 19),
            Location("Techiman", 19),
            Location("Gbawe", 21),
            Location("Ejura", 19),
            Location("Taifa", 35),
            Location("Bolgatanga", 23),
            Location("Suhum", 17),
        )
        val sortedLocation = locations.sortedBy { location -> location.name }
        locationAdapter = LocationAdapter(requireContext())
        locationAdapter.setDataList(sortedLocation)
        val llm = LinearLayoutManager(context)
        llm.stackFromEnd = true     // items gravity sticks to bottom
//        llm.reverseLayout = false
        recyclerview_Location.layoutManager = llm

        recyclerview_Location.adapter = locationAdapter

        searchView.isSubmitButtonEnabled = true
    }

    private fun performSearch() {
        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                search(query)
                return true
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                search(newText)
                return true
            }
        })
    }

    private fun search(text: String?) {
        matchedLocations = arrayListOf()

        text?.let {
            locations.forEach { location ->
                if (location.name.contains(text, true) ||
                    location.amount.toString().contains(text, true)
                ) {
                    matchedLocations.add(location)
                }
            }
            updateRecyclerView()
            if (matchedLocations.isEmpty()) {
                Toast.makeText(context, "No match found!", Toast.LENGTH_SHORT).show()
            }
            updateRecyclerView()
        }
    }

    private fun updateRecyclerView() {
        val sortedMatchedLocations = matchedLocations.sortedBy { location -> location.name }

        locationAdapter.setDataList(sortedMatchedLocations)

    }




}