package com.example.tendoapp.ui.main.view.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.example.tendoapp.R
import com.example.tendoapp.databinding.ActivityProductBinding
import kotlinx.android.synthetic.main.activity_product.*

class ProductActivity : AppCompatActivity() {
    lateinit var binding:ActivityProductBinding
    private var imageList = mutableListOf<Int>()
    private var LinearLayout = dots_container

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=DataBindingUtil.setContentView(this, R.layout.activity_product)


    }
    private fun addToList(title: String, image: Int){
        imageList.add(image)
    }

    private fun postToList(){
        for (i in 1..5){
            //addToList(R.drawable.tisho)
            //addToList(R.drawable.tisho2)
            //addToList( R.drawable.tisho3)
            //addToList( R.drawable.tisho4)

        }
    }

}