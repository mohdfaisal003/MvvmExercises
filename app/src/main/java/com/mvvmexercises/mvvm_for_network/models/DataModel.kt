package com.mvvmexercises.mvvm_for_network.models

data class DataModel(val id: Int,val title: String,val price: String,val category: String,val description: String,val image: String) {
    override fun toString(): String {
        return "{id=$id, title='$title', price='$price', category='$category', description='$description', image='$image'}"
    }
}