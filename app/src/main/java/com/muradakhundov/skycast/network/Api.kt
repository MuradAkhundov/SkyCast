package com.muradakhundov.skycast.network

import com.muradakhundov.skycast.models.DailyForecasts
import com.muradakhundov.skycast.models.HourlyForecast
import com.muradakhundov.skycast.models.Location
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

const val APIKEY = "YOUR_API_KEY"

interface Api {
    @GET("locations/v1/cities/search")
    suspend fun sendLocation(
        @Query("apikey") apiKey : String = APIKEY,
        @Query("q") query : String
    ) : Response<List<Location>>


    @GET("forecasts/v1/daily/5day/{location_key}")
    suspend fun getDailyForecasts(
        @Path("location_key") locationKey : String,
        @Query("apikey") apiKey : String = APIKEY,
        @Query("metric") metric : Boolean = true
    ) : Response<DailyForecasts>


    @GET("forecasts/v1/hourly/12hour/{location_key}")
    suspend fun getHourlyForecasts(
        @Path("location_key") locationKey : String,
        @Query("apikey") apiKey : String = APIKEY,
        @Query("metric") metric : Boolean = true
    ) : Response<List<HourlyForecast>>
}
