package com.mvvmexercises.mvvm_for_network.repositories

import com.google.gson.JsonObject
import com.mohd.androidweb.boilerplates.appbase_boilerplate.network.ApiCallBack
import com.mvvmexercises.mvvm_for_network.models.DataModel
import com.mvvmexercises.mvvm_for_network.network.RetrofitHelper
import retrofit2.Response

class ProductRepo: RetrofitHelper() {

    suspend fun addProducts(jsonObject: JsonObject): Response<DataModel> {
        return apiCallBack.addProduct(jsonObject)
    }
}