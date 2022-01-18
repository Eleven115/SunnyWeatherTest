package com.example.sunnyweather.logic.network

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import kotlin.coroutines.resume
import kotlin.coroutines.resumeWithException
import kotlin.coroutines.suspendCoroutine


/*
* 统一的网络数据源访问入口
* */
object SunnyWeatherNetwork {

    /*
    * 这个就相当于 Call<SearchResult> task = mApi.doSearch(mCurrentPage, keyword);
    * 后面可以直接用这个task.enqueue了
    * */
    private val placeService = ServiceCreator.create<PlaceService>()

    /*
    *  suspend携程  await()是挂起函数
    * suspendCoroutine函数来挂起当前协程
    * */
//    搜索城市数据请求
    suspend fun searchPlaces(query: String) = placeService.searchPlaces(query).await()

//
    private suspend fun <T> Call<T>.await(): T {
        return suspendCoroutine { continuation ->
            enqueue(object : Callback<T> {
                override fun onResponse(call: Call<T>, response: Response<T>) {
                    val body = response.body()
                    if (body != null) continuation.resume(body)
                    else continuation.resumeWithException(
                        RuntimeException("response body is null")
                    )
                }

                override fun onFailure(call: Call<T>, t: Throwable) {
                    continuation.resumeWithException(t)
                }
            })
        }
    }
}