package com.example.tendoapp.ui.main.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.tendoapp.R
import com.example.tendoapp.data.model.Category
import com.example.tendoapp.data.model.Location
import com.example.tendoapp.ui.main.view.`interface`.BottomSheetInterface
import kotlinx.android.synthetic.main.item_category_type.view.*
import kotlinx.android.synthetic.main.item_location.view.*
import kotlinx.android.synthetic.main.item_product_cart.view.*

/**
 * Created by goodlife on 10,September,2021
 */

class LocationAdapter(var context:Context) : RecyclerView.Adapter<LocationAdapter.ViewHolder>() {

    var  list = emptyList<Location>()


    internal fun setDataList(list: List<Location>){
        this.list = list
        notifyDataSetChanged()
    }
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        var linearLayout:LinearLayout =itemView.linearLayout_main
        var tv_location_name : TextView = itemView.tv_location_name
        var tv_cost : TextView = itemView.tv_cost

    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        var view = LayoutInflater.from(parent.context).inflate(
            R.layout.item_location,
            parent,
            false
        )
        return ViewHolder(view)
    }
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val data = list[position]
        holder.tv_location_name.text = data.name
        "₵${data.amount}".also { holder.tv_cost.text = it }
        holder.linearLayout.setOnClickListener {

        }

    }

    override fun getItemCount(): Int = list.size


}