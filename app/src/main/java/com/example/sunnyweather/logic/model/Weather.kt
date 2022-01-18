package com.example.sunnyweather.logic.model


//model层是 数据模型
//用于将Realtime和Daily对象 封装起来
data class Weather(val realtime: RealtimeResponse.RealTime, val daily: DailyResponse.Daily) {
}