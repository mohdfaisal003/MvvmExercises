package com.mohd.androidweb.boilerplates.appbase_boilerplate.network

import com.google.gson.JsonObject
import com.mvvmexercises.mvvm_for_network.models.DataModel
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface ApiCallBack {

    @POST(WebConst.add_product_key)
    suspend fun addProduct(@Body jsonObject: JsonObject): Response<DataModel>
}