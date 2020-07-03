package com.example.forecastmvvm.data.db.unitlocalized

import androidx.room.ColumnInfo

data class MetricCurrentWeatherEntry(
    @ColumnInfo(name = "temparature")
    override val temperature: Double,
    @ColumnInfo(name = "condition_text")
    override val conditionText: String,
    @ColumnInfo(name = "condition_icon")
    override val condtionIconUrl: String,
    @ColumnInfo(name = "wind_speed")
    override val windspeed: Double,
    @ColumnInfo(name = "wind_dir")
    override val windDiretion: String,
    @ColumnInfo(name = "precip")
    override val precipitationVolume: Double,
    @ColumnInfo(name = "feelslike")
    override val feelLikeTemperature: Double,
    @ColumnInfo(name = "visibility")
    override val visibilityDistance: Double

):UnitSpecificCurrentWeatherEntry