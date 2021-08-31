package com.example.tendoapp.ui.main.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.tendoapp.R
import com.example.tendoapp.data.model.Product
import com.example.tendoapp.ui.main.view.activities.ProductActivity
import kotlinx.android.synthetic.main.recyclerview_layout.view.*

class ProductsAdapter(var context: Context) : RecyclerView.Adapter<ProductsAdapter.ViewHolder>() {

    var  dataList = emptyList<Product>()

    internal fun setDataList(dataList: List<Product>){
        this.dataList = dataList
        notifyDataSetChanged()
    }
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        var image : ImageView
        var value : TextView
        var price : TextView

        init {
            image = itemView.image
            value = itemView.value
            price = itemView.price
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        var view = LayoutInflater.from(parent.context).inflate(
            R.layout.recyclerview_layout,
            parent,
            false
        )
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        var data = dataList[position]

        holder.value.text = data.value
        holder.price.text = data.price

        holder.image.setImageResource(data.image)

        holder.itemView.setOnClickListener {
            val i = Intent(context, ProductActivity::class.java)
            context.startActivity(i)
        }

    }

    override fun getItemCount() = dataList.size

}