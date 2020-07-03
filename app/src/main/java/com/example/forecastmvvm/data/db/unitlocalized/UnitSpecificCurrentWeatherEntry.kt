package com.example.forecastmvvm.data.db.unitlocalized

interface UnitSpecificCurrentWeatherEntry {
    val temperature :Double
    val conditionText : String
    val condtionIconUrl : String
    val windspeed : Double
    val windDiretion : String
    val precipitationVolume : Double
    val feelLikeTemperature : Double
    val visibilityDistance : Double
}