package com.muradakhundov.skycast.repositories

import com.muradakhundov.skycast.models.BaseModel
import com.muradakhundov.skycast.models.DailyForecasts
import com.muradakhundov.skycast.models.HourlyForecast
import com.muradakhundov.skycast.models.Location
import com.muradakhundov.skycast.network.Api
import retrofit2.Response

class WeatherRepoImpl(private val api : Api) : WeatherRepo {
    override suspend fun searchLocation(query: String): BaseModel<List<Location>> {
        return request{
            api.sendLocation(query = query)
        }
    }

    override suspend fun getDailyForecasts(locationKey: String): BaseModel<DailyForecasts> {
        return  request {
            api.getDailyForecasts(locationKey = locationKey)
        }
    }

    override suspend fun getHourlyForecasts(locationKey: String): BaseModel<List<HourlyForecast>> {
        return request {
            api.getHourlyForecasts( locationKey = locationKey)
        }
    }
}
suspend fun <T> request(request : suspend () -> Response<T>) : BaseModel<T>{
    try {
        request().also {
            return if(it.isSuccessful){
                BaseModel.Success(it.body()!!)
            }
            else{
                BaseModel.Error(it.errorBody()?.string().toString())
            }
        }
    }catch (e : Exception){
        return BaseModel.Error(e.message.toString())
    }
}
