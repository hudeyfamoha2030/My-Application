package com.example.tendoapp.data.model

import android.media.Image
import java.util.*
import kotlin.collections.ArrayList

data class Product(var value: String, var price: String, var image : Int)
data class Category(var viewType: Int, var name: String, var image : Int , var products: ArrayList<Product> ? = null)
data class Location(
    val name: String,
    val amount: Int
)

data class Transaction(var image: Int, var date: Date, var status: String, var amount: Int)