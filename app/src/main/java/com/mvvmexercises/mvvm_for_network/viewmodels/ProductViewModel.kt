package com.mvvmexercises.mvvm_for_network.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.gson.JsonObject
import com.mvvmexercises.mvvm_for_network.models.DataModel
import com.mvvmexercises.mvvm_for_network.repositories.ProductRepo
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Response

open class ProductViewModel: ViewModel() {

    val productRepo = ProductRepo()
    val addProduct = MutableLiveData<DataModel>()
    val error = MutableLiveData<String>()

    fun addProduct(jsonObject: JsonObject) {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                if (jsonObject != null) {
                    val response: Response<DataModel> = productRepo.addProducts(jsonObject)
                    if (response.isSuccessful && response.body() != null) {
                        addProduct.postValue(response.body())
                    } else if (response.code() >= 400) {
                        error.postValue("Error: No Data Available!!")
                    }
                } else {
                    error.postValue("Error: JsonObject is null!!")
                }

            } catch (exception: Exception) {
                error.postValue("Error: ${exception.message}")
            }
        }
    }
}