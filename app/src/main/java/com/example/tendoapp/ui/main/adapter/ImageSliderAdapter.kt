package com.example.tendoapp.ui.main.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2
import com.example.tendoapp.R
import com.example.tendoapp.data.model.SliderItem

class ImageSliderAdapter(
    private val viewPager: ViewPager2,
    private val imageList:ArrayList<SliderItem>
): RecyclerView.Adapter<ImageSliderAdapter.ImageSliderViewHolder>(){

    inner class ImageSliderViewHolder(view: View): RecyclerView.ViewHolder(view){
        val image: ImageView =view.findViewById<ImageView>(R.id.ivSlidingImageItem)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ImageSliderViewHolder {
        val view=
            LayoutInflater.from(parent.context).inflate(R.layout.item_image_slider,parent,false)
        return ImageSliderViewHolder(view)
    }

    override fun onBindViewHolder(holder: ImageSliderViewHolder, position: Int) {
        val currentImage=imageList[position]
        holder.image.setImageResource(currentImage.image)

        if(position == imageList.size-2){
            viewPager.post(run)
        }

    }

    private val run= Runnable {
        imageList.addAll(imageList)
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int {
        return imageList.size
    }
}