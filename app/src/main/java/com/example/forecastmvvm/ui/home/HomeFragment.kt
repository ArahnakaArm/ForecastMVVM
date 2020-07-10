package com.example.forecastmvvm.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.forecastmvvm.R
import com.example.forecastmvvm.data.ApixuWeatherApiService
import com.example.forecastmvvm.data.network.ConnectivityInterceptor
import com.example.forecastmvvm.data.network.ConnectivityInterceptorImpl
import com.example.forecastmvvm.data.network.WeatherNetworkDataSource
import com.example.forecastmvvm.data.network.WeatherNetworkDataSourceImpl
import com.example.forecastmvvm.data.network.response.CurrentWeatherResponse
import com.example.forecastmvvm.internal.glide.GlideApp
import com.example.forecastmvvm.ui.base.ScopedFragment
import kotlinx.android.synthetic.main.fragment_home.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import org.kodein.di.Kodein
import org.kodein.di.KodeinAware
import org.kodein.di.android.x.closestKodein
import org.kodein.di.generic.instance

class HomeFragment : ScopedFragment(),KodeinAware {
    override val kodein by closestKodein()

    private val viewModelFactory : CurrentWeatherViewModelFactory by instance()

    private lateinit var homeViewModel: HomeViewModel

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        homeViewModel =
                ViewModelProviders.of(this,viewModelFactory).get(HomeViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_home, container, false)
       /* val textView: TextView = root.findViewById(R.id.text_home)
        homeViewModel.text.observe(viewLifecycleOwner, Observer {
            textView.text = it
        })*/
        return root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
      /*  val apiService = ApixuWeatherApiService(ConnectivityInterceptorImpl(this.context!!))
        val weatherNetworkDataSource = WeatherNetworkDataSourceImpl(apiService)

        weatherNetworkDataSource.downloadedCurrentWeather.observe(this, Observer {
            text_home.text = it.toString()
        })

        GlobalScope.launch(Dispatchers.Main) {
            weatherNetworkDataSource.fetchCurrentWeather("New York")
        }*/

        bindUI()
    }
    private fun bindUI() = launch{
        val currentWeather = homeViewModel.weather.await()
        currentWeather.observe(this@HomeFragment , Observer {
            if (it == null) return@Observer

            group_loading.visibility = View.GONE
            updateLocation("London")
            updateDateToToday()
            updateTemperatures(it.temperature,it.feelLikeTemperature)
            updatePrecipitation(it.precip)
            updateWind(it.windDiretion,it.windspeed)
            updateVisibility(it.visibilityDistance)
            updateCondition(it.weather_descriptions)
            //text_home.text = it.toString()
            GlideApp.with(this@HomeFragment)
                .load(it.weather_icons)
                .into(imageView_condition_icon)
        })
    }
    private fun updateLocation(location : String){
        (activity as? AppCompatActivity)?.supportActionBar?.title = location
    }
    private fun updateDateToToday(){
        (activity as? AppCompatActivity)?.supportActionBar?.subtitle = "Today"
    }
    private fun updateTemperatures(temperature : Double,feellike : Double){
        val unitAbbreviation = if (homeViewModel.isMetric) "°C" else "°F"
        textView_temperature.text = "$temperature$unitAbbreviation"
        textView_feels_like_temperature.text = "Feellike $feellike$unitAbbreviation"
    }
    private fun updatePrecipitation(precipVolume : Double){
        val unitAbbreviation = if (homeViewModel.isMetric) "mm" else "in"
        textView_precipitation.text = "Preciptiation: $precipVolume $unitAbbreviation"
    }
    private fun updateWind(windDirection : String,windSpeed : Double){
        val unitAbbreviation = if (homeViewModel.isMetric) "kph" else "mph"
        textView_wind.text = "Wind: $windDirection, $windSpeed $unitAbbreviation"
    }
    private fun updateVisibility(visibilityDistance : Double){
        val unitAbbreviation = if (homeViewModel.isMetric) "km" else "mi"
        textView_visibility.text = "Visibility: $visibilityDistance $unitAbbreviation"
    }
    private fun updateCondition(description : String){
        textView_condition.text = "$description"
    }
}