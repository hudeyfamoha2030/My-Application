package com.example.tendoapp.ui.main.adapter

import android.content.Context
import android.content.Intent
import android.graphics.drawable.Drawable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.tendoapp.R
import com.example.tendoapp.data.model.Category
import com.example.tendoapp.data.model.Transaction
import com.example.tendoapp.ui.main.view.activities.OrderDetailsActivity
import com.example.tendoapp.ui.main.view.activities.ProductActivity
import kotlinx.android.synthetic.main.item_category_type.view.*
import kotlinx.android.synthetic.main.item_product_cart.view.*
import kotlinx.android.synthetic.main.item_product_cart.view.tv_name
import kotlinx.android.synthetic.main.item_product_cart.view.img_icon
import kotlinx.android.synthetic.main.item_wallet.view.*
import kotlinx.android.synthetic.main.recyclerview_layout_item_category.view.*


class MyOderDetailsAdapter(var context: Context) : RecyclerView.Adapter<MyOderDetailsAdapter.ViewHolder>() {

    var  datalisttransaction = emptyList<Transaction>()

    internal fun setDataList(datalisttransaction: List<Transaction>){
        this.datalisttransaction = datalisttransaction
        notifyDataSetChanged()
    }
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        //   var image_wallet: ImageView =itemView.image_wallet
         //   var tv_pending: TextView = itemView.tv_pending
         //   var tv_wallet: TextView = itemView.tv_wallet
           // var tv_date: TextView = itemView.tv_date
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        var view = LayoutInflater.from(parent.context).inflate(
            R.layout.item_order_details,
            parent,
            false
        )
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        var data = datalisttransaction[position]
       // holder.tv_pending.text = data.status
     //   holder.tv_wallet.text = "GHS"+data.amount.toString()
       // holder.tv_date.text = data.date.toString()


       // holder.image_wallet.setImageResource(data.image)

    }

    override fun getItemCount() = datalisttransaction.size
}