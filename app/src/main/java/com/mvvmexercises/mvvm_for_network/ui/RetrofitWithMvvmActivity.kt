package com.mvvmexercises.mvvm_for_network.ui

import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.google.gson.JsonObject
import com.mvvmexercises.databinding.ActivityRetrofitWithMvvmBinding
import com.mvvmexercises.mvvm_for_network.viewmodels.ProductViewModel

class RetrofitWithMvvmActivity : AppCompatActivity() {

    lateinit var binding: ActivityRetrofitWithMvvmBinding
    private val productViewModel by viewModels<ProductViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRetrofitWithMvvmBinding.inflate(layoutInflater)
        setContentView(binding.root)

        /* Request Body */
        val jsonObject = JsonObject()
        jsonObject.addProperty("title", "Product Title")
        jsonObject.addProperty("price", 13.5)
        jsonObject.addProperty("description", "lorem ipsum set")
        jsonObject.addProperty("image", "https://i.pravatar.cc")
        jsonObject.addProperty("category", "electronic")

        binding.addProductBtn.setOnClickListener {
            productViewModel.addProduct(jsonObject)
        }

        productViewModel.addProduct.observe(this, Observer {
            if (it != null)
                Log.d("addProduct", it.toString())
        })

        productViewModel.error.observe(this, Observer {
            Log.d("addProductError", it)
        })
    }
}