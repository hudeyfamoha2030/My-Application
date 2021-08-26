package com.example.tendoapp.ui.main.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.tendoapp.R
import kotlinx.android.synthetic.main.product_page_item.view.*

class ViewPager2Adapter(private var images: List<Int>) : RecyclerView.Adapter<ViewPager2Adapter.Pager2ViewHolder>() {

    inner class Pager2ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val itemImage: ImageView =itemView.Iv_Image

        init {
            itemImage.setOnClickListener { V: View ->
                val position = adapterPosition
                Toast.makeText(itemView.context, "you clicked on item #${position + 1}", Toast.LENGTH_SHORT).show()
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewPager2Adapter.Pager2ViewHolder {
        return Pager2ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.product_page_item, parent, false))
    }

    override fun onBindViewHolder(holder: ViewPager2Adapter.Pager2ViewHolder, position: Int) {

        holder.itemImage.setImageResource(images[position])
    }

    override fun getItemCount(): Int {
        return images.size
    }
}