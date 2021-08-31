package com.example.tendoapp.ui.main.adapter

import android.content.Context
import android.graphics.drawable.Drawable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.recyclerview.widget.RecyclerView
import com.example.tendoapp.R
import com.example.tendoapp.data.model.Category
import kotlinx.android.synthetic.main.recyclerview_layout_item_category.view.*


class CategoriesAdapter(var context: Context) : RecyclerView.Adapter<CategoriesAdapter.ViewHolder>() {

    var  dataList = emptyList<Category>()

    internal fun setDataList(dataList: List<Category>){
        this.dataList = dataList
        notifyDataSetChanged()
    }
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        var btn : Button = itemView.btnCategory

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        var view = LayoutInflater.from(parent.context).inflate(
            R.layout.recyclerview_layout_item_category,
            parent,
            false
        )
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        var data = dataList[position]
        holder.btn.text = data.value
        val img: Drawable = this.context.resources.getDrawable(data.image)
        holder.btn.setCompoundDrawablesWithIntrinsicBounds(img, null, null, null)
    }

    override fun getItemCount() = dataList.size
}