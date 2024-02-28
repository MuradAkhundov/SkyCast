package com.muradakhundov.skycast.repositories

import com.muradakhundov.skycast.models.BaseModel
import com.muradakhundov.skycast.models.DailyForecasts
import com.muradakhundov.skycast.models.HourlyForecast
import com.muradakhundov.skycast.models.Location
import retrofit2.http.Query

interface WeatherRepo {
    suspend fun searchLocation(query: String) : BaseModel<List<Location>>
    suspend fun getDailyForecasts(locationKey : String) : BaseModel<DailyForecasts>
    suspend fun getHourlyForecasts(locationKey: String) : BaseModel<List<HourlyForecast>>
}