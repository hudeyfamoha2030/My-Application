package com.example.tendoapp.utils.objects

import com.example.tendoapp.R
import com.example.tendoapp.data.model.ChildModel
import java.util.*

object ChildDataFactory{

    private val random = Random()

    private val titles =  arrayListOf( "t-shirt", "trouser", "shoes")

    private fun randomTitle() : String{
        val index = random.nextInt(titles.size)
        return titles[index]
    }

    private fun randomImage() : Int{
        return(R.drawable.tshirt)
        return(R.drawable.tisho)
        return(R.drawable.tisho3)


    }

    fun getChildren(count : Int) : List<ChildModel>{
        val children = mutableListOf<ChildModel>()
        repeat(count){
            val child = ChildModel(randomImage(), randomTitle())
            children.add(child)
        }
        return children
    }


}