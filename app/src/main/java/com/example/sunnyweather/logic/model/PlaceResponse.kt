package com.example.sunnyweather.logic.model

import com.google.gson.annotations.SerializedName

/*
* 数据模型  SerializedName注射是让JSON字段和Java字段之间建立映射关系。
* */
data class PlaceResponse(val status: String, val places: List<Place>)

data class Place(val name: String, val location: Location,
                 @SerializedName("formatted_address") val address: String)

data class Location(val lng: String, val lat: String)