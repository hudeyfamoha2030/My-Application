package com.example.tendoapp.ui.main.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.tendoapp.R
import com.example.tendoapp.data.model.Category
import com.example.tendoapp.data.model.Data
import kotlinx.android.synthetic.main.fragment_shares.*
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.fragment_orders.*


class RecyclerViewAdapter(context: Context, list: ArrayList<Category>) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    companion object {
        const val VIEW_TYPE_ONE = 1 //images_horizontal
        const val VIEW_TYPE_TWO = 2 //images_vertical
    }

    private val context: Context = context
    var list: ArrayList<Category> = list
    lateinit var mySharesAdapter: MySharesAdapter

    private inner class View1ViewHolder(itemView: View) :
        RecyclerView.ViewHolder(itemView) {
        var message: TextView = itemView.findViewById(R.id.tv_title)
        var recyclerview: RecyclerView = itemView.findViewById(R.id.recyclerViewProducts)
        fun bind(position: Int) {
            val category = list[position]
            message.text = category.name

            recyclerview.layoutManager=LinearLayoutManager(context,LinearLayoutManager.HORIZONTAL, true)
            mySharesAdapter = MySharesAdapter(context)
            category.products?.let { mySharesAdapter.setDataList(it) }
            recyclerview.adapter = mySharesAdapter
        }
    }

    private inner class View2ViewHolder(itemView: View) :
        RecyclerView.ViewHolder(itemView) {
        var message: TextView = itemView.findViewById(R.id.tv_title)
        var recyclerview: RecyclerView = itemView.findViewById(R.id.recyclerViewProducts)

        fun bind(position: Int) {
            val category = list[position]
            message.text = category.name
            recyclerview.layoutManager= GridLayoutManager(context,2)
            mySharesAdapter = MySharesAdapter(context)
            category.products?.let { mySharesAdapter.setDataList(it) }
            recyclerview.adapter = mySharesAdapter
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {

        when (viewType) {
            VIEW_TYPE_ONE -> {
                return View1ViewHolder(
                    LayoutInflater.from(context).inflate(R.layout.item_view_type_one, parent, false)
                )
            }
            VIEW_TYPE_TWO -> {
                return View2ViewHolder(
                    LayoutInflater.from(context).inflate(R.layout.item_view_type_one, parent, false)
                )
            }
            else -> { // Note the block
                return View1ViewHolder(
                    LayoutInflater.from(context).inflate(R.layout.item_view1, parent, false)
                )
            }
        }
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (list[position].viewType) {
            VIEW_TYPE_ONE -> {
                (holder as View1ViewHolder).bind(position)
            }
            else -> {
                (holder as View2ViewHolder).bind(position)
            }

        }
    }

    override fun getItemViewType(position: Int): Int {
        return list[position].viewType
    }
}