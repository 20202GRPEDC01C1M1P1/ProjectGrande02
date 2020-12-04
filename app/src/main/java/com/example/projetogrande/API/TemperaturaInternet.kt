package com.example.projetogrande.API

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object TemperaturaInternet {

    private var retrofit = Retrofit
        .Builder()
        .baseUrl("http://dataservice.accuweather.com")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    fun getTemperaturaService(): TemperaturaService {
        return retrofit.create(TemperaturaService::class.java)
    }
}