package com.example.sunnyweather.logic

import androidx.lifecycle.liveData
import com.example.sunnyweather.logic.model.Place
import com.example.sunnyweather.logic.network.SunnyWeatherNetwork
import kotlinx.coroutines.Dispatchers
import java.lang.Exception

/*
* Repository   这里用的是无法直接取得的LiveData对象的平替方法
*  ：liveData()函数是lifecycle-livedata-ktx库提供的一个非常强大且好用的功能
* */
object Repository {
    /*
    * liveData() 它可以自动构建并返回一个LiveData对象，然后在它的代码块中
      提供一个挂起函数的上下文
    * */
//    Dispatchers.IO 将所有代码都指定在子线程中    下面的代码相当于去服务器请求数据
    fun searchPlaces(query: String) = liveData(Dispatchers.IO) {
        val result = try {
            val placeResponse = SunnyWeatherNetwork.searchPlaces(query)
            if (placeResponse.status == "ok") {
                val places = placeResponse.places
//                Kotlin内置的Result.success()方法来包装获 取的城市数据列表
                Result.success(places)
            } else {
                Result.failure(RuntimeException("response status is ${placeResponse.status}"))
            }
        } catch (e: Exception) {
            Result.failure<List<Place>>(e)
        }
        /*
        * emit()方法将包装的结果发射出去，这个emit()方法其实类似于调用LiveData的
          setValue()方法来通知数据变化
        * */
        emit(result)
    }
}