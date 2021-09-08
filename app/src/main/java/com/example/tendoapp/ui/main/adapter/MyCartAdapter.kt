package com.example.tendoapp.ui.main.adapter

import android.content.Context
import android.graphics.drawable.Drawable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.tendoapp.R
import com.example.tendoapp.data.model.Category
import kotlinx.android.synthetic.main.item_category_type.view.*
import kotlinx.android.synthetic.main.item_product_cart.view.*
import kotlinx.android.synthetic.main.item_product_cart.view.tv_name
import kotlinx.android.synthetic.main.item_product_cart.view.img_icon
import kotlinx.android.synthetic.main.recyclerview_layout_item_category.view.*


class MyCartAdapter(var context: Context) : RecyclerView.Adapter<MyCartAdapter.ViewHolder>() {

    var  dataList = emptyList<Category>()

    internal fun setDataList(dataList: List<Category>){
        this.dataList = dataList
        notifyDataSetChanged()
    }
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        var tv_name : TextView = itemView.tv_name
        var img_icon: ImageView =itemView.img_icon

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        var view = LayoutInflater.from(parent.context).inflate(
            R.layout.item_product_cart,
            parent,
            false
        )
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        var data = dataList[position]
        holder.tv_name.text = data.name
        holder.img_icon.setImageResource(data.image)

    }

    override fun getItemCount() = dataList.size
}