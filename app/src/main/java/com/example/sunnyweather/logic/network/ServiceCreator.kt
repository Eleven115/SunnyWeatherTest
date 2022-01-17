package com.example.sunnyweather.logic.network

import androidx.annotation.RestrictTo
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/*
* Retrofit构建器  object使它成为单例类
* 调用create的时候传入api的Service就好了
*
* */
object ServiceCreator {
    private const val BASE_URL = "https://api.caiyunapp.com/"
    private val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

    fun <T> create(serviceClass: Class<T>): T = retrofit.create(serviceClass)
    inline fun <reified T> create(): T = create(T::class.java)
}