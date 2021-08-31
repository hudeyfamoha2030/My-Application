package com.example.tendoapp.ui.main.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.tendoapp.R
import kotlinx.android.synthetic.main.item_image_viewpager.view.*

class ViewPagerImageAdapter(
    val imagesList:List<Int>
): RecyclerView.Adapter<ViewPagerImageAdapter.ViewPagerViewHolder>() {
    inner class ViewPagerViewHolder(itemView: View): RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewPagerViewHolder {
        val view=
            LayoutInflater.from(parent.context).inflate(R.layout.item_image_viewpager,parent,false)
        return ViewPagerViewHolder(view)

    }

    override fun onBindViewHolder(holder: ViewPagerViewHolder, position: Int) {
        val currentImage=imagesList[position]
        holder.itemView.ivViewPagerItem.setImageResource(currentImage)
    }

    override fun getItemCount(): Int {
        return imagesList.size
    }
}