package com.example.forecastmvvm.data.db.entity


import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import com.google.gson.annotations.SerializedName

const val CURRENT_WEATHER_ID = 0

@Entity(tableName = "current_weather")
data class Current(
    @SerializedName("cloudcover")
    val cloudcover: Int,
    @SerializedName("feelslike")
    val feelslike: Int,
    @TypeConverters(Converters::class)
    @SerializedName("weather_descriptions")
    val weather_descriptions: List<String>,
    @TypeConverters(Converters::class)
    @SerializedName("weather_icons")
    val weather_icons: List<String>,
    /*@Embedded(prefix = "condition_")
    val condition: Condition,*/
    @SerializedName("humidity")
    val humidity: Int,
    @SerializedName("observation_time")
    val observationTime: String,
    @SerializedName("precip")
    val precip: Double,
    @SerializedName("pressure")
    val pressure: Int,
    @SerializedName("temparature")
    val temparature: Int,
    @SerializedName("uv_index")
    val uvIndex: Int,
    @SerializedName("visibility")
    val visibility: Int,
    @SerializedName("weather_code")
    val weatherCode: Int,
    @SerializedName("wind_degree")
    val windDegree: Int,
    @SerializedName("wind_dir")
    val wind_dir: String,
    @SerializedName("wind_speed")
    val wind_speed: Int
){
    @PrimaryKey(autoGenerate = false)
    var id : Int = 0
}