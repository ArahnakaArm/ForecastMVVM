package com.example.forecastmvvm.data.network.response


import com.example.forecastmvvm.data.db.entity.Current
import com.example.forecastmvvm.data.db.entity.Location
import com.example.forecastmvvm.data.db.entity.Request
import com.google.gson.annotations.SerializedName

data class CurrentWeatherResponse(
    @SerializedName("current")
    val current: Current,
    @SerializedName("location")
    val location: Location,
    @SerializedName("request")
    val request: Request
)