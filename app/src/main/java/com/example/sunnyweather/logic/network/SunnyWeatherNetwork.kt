package com.example.sunnyweather.logic.network

import retrofit2.await


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
* 携程  先把
* */
    suspend fun searchPlaces(query: String) = placeService.searchPlaces(query).await()
}