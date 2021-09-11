package com.example.tendoapp.data.model

data class Product(var value: String, var price: String, var image : Int)
data class Category(var viewType: Int, var name: String, var image : Int , var products: ArrayList<Product> ? = null)
data class Location(
    val name: String,
    val amount: Int
)