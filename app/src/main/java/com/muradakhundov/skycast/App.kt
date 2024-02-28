package com.muradakhundov.skycast

import android.app.Application
import com.muradakhundov.skycast.network.Api
import com.muradakhundov.skycast.network.HeaderInterceptor
import com.muradakhundov.skycast.repositories.WeatherRepo
import com.muradakhundov.skycast.repositories.WeatherRepoImpl
import okhttp3.OkHttpClient
import org.koin.core.context.startKoin
import org.koin.dsl.bind
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class App : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin{
            modules(module {
                single{
                    val client = OkHttpClient.Builder()
                        .addInterceptor(HeaderInterceptor())
                        .build()
                    Retrofit
                        .Builder()
                        .addConverterFactory(GsonConverterFactory.create())
                        .client(client)
                        .baseUrl("http://dataservice.accuweather.com/")
                        .build()
                }
                single {
                    val retrofit : Retrofit = get()
                    retrofit.create(Api::class.java)
                }
                single {
                    val api : Api = get()
                    WeatherRepoImpl(api)
                } bind WeatherRepo :: class
            })
        }
    }
}