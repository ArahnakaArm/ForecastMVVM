package com.example.forecastmvvm.data.db.unitlocalized

import androidx.room.ColumnInfo

data class ImperialCurrentWeatherEntry(
    @ColumnInfo(name = "temperature")
    override val temperature: Double,
    @ColumnInfo(name = "weather_descriptions")
    override val weather_descriptions: String,
    @ColumnInfo(name = "weather_icons")
    override val weather_icons: String,
    @ColumnInfo(name = "wind_speed")
    override val windspeed: Double,
    @ColumnInfo(name = "wind_dir")
    override val windDiretion: String,
    @ColumnInfo(name = "precip")
    override val precip: Double,
    @ColumnInfo(name = "feelslike")
    override val feelLikeTemperature: Double,
    @ColumnInfo(name = "visibility")
    override val visibilityDistance: Double

):UnitSpecificCurrentWeatherEntry