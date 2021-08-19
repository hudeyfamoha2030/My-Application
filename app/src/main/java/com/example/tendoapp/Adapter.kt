package com.example.tendoapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.recyclerview_layout.view.*

class Adapter(var list: ArrayList<DataModel>) : RecyclerView.Adapter<Adapter.Viewholder>() {
    class Viewholder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var text_value = itemView.text_value
        var text_price = itemView.text_price
        var imageview = itemView.imageview

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Viewholder {
        return Viewholder(
            LayoutInflater.from(parent.context).inflate(R.layout.recyclerview_layout, parent, false))
    }

    override fun onBindViewHolder(holder: Viewholder, position: Int) {
        holder.text_value.text = list[position].text_value
        holder.text_price.text = list[position].text_price
        holder.imageview.setImageResource(list[position].image_id)

    }

    override fun getItemCount(): Int {
        return list.size
    }
}