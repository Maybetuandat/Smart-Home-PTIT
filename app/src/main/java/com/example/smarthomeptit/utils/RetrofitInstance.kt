package com.example.smarthomeptit.utils

import com.example.smarthomeptit.data.api.ApiInterface
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {
    val api: ApiInterface by lazy {
        Retrofit.Builder()
            .baseUrl(url)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ApiInterface::class.java)
    }
    const val url = "http://192.168.20.206:9999"
    const val urlApiDocs = url + "/api-docs/"
}