package com.example.forecastmvvm.data.db.unitlocalized

interface UnitSpecificCurrentWeatherEntry {
    val temperature :Double
    val weather_descriptions : String
    val weather_icons : String
    val windspeed : Double
    val windDiretion : String
    val precip : Double
    val feelLikeTemperature : Double
    val visibilityDistance : Double
}