package com.example.tendoapp.utils.objects

import com.example.tendoapp.data.model.ChildModel
import com.example.tendoapp.data.model.ParentModel
import java.util.*

object ParentDataFactory{
    private val random = Random()

    private val titles =  arrayListOf( "man work equipment", "women shirts", "man shirts")

    private fun randomTitle() : String{
        val index = random.nextInt(titles.size)
        return titles[index]
    }

    private fun randomChildren() : List<ChildModel>{
        return ChildDataFactory.getChildren(3)
    }

    fun getParents(count : Int) : List<ParentModel>{
        val parents = mutableListOf<ParentModel>()
        repeat(count){
            val parent = ParentModel(randomTitle(), randomChildren())
            parents.add(parent)
        }
        return parents
    }
}