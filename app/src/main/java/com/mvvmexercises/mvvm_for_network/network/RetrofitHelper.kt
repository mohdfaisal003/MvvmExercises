package com.mvvmexercises.mvvm_for_network.network

import com.google.gson.GsonBuilder
import com.mohd.androidweb.boilerplates.appbase_boilerplate.network.ApiCallBack
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.io.IOException
import java.util.concurrent.TimeUnit
import kotlin.jvm.Throws

open class RetrofitHelper {

    private val baseUrl = "https://fakestoreapi.com/"

    class NetworkInterceptor: Interceptor {
        @Throws(IOException::class)
        override fun intercept(chain: Interceptor.Chain): Response {
            val request: Request = chain.request()
                .newBuilder()
                .addHeader("Content-Type","application/json")
                .build()
            return chain.proceed(request)
        }
    }

    private val okHttpClient = OkHttpClient.Builder()
        .addInterceptor(NetworkInterceptor())
        .callTimeout(60L, TimeUnit.SECONDS)
        .readTimeout(60L, TimeUnit.SECONDS)
        .retryOnConnectionFailure(true)
        .build()

    val apiCallBack: ApiCallBack by lazy {
        Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .client(okHttpClient)
            .build()
            .create(ApiCallBack::class.java)
    }
}