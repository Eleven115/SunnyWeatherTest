package com.example.sunnyweather

import android.annotation.SuppressLint
import android.app.Application
import android.content.Context

/*
* 提供一个全局获取Context的方式
* Api令牌也放在这里
* */
class SunnyWeatherApplication : Application() {
    companion object{
        const val TOKEN = "qCSC7fJZDrQWHtDT"
        @SuppressLint("StaticFieldLeak")
        lateinit var context: Context
    }

    override fun onCreate() {
        super.onCreate()
        context = applicationContext
    }
}