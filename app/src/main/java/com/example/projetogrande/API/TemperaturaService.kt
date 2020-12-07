package com.example.projetogrande.API

import retrofit2.http.*

private const val apikey = "hFzcBauIm17YRj0mO3gIU9VA6gHAXh9G"

interface TemperaturaService {

    @GET("/forecasts/v1/daily/5day/2729725?apikey=$apikey")
    suspend fun all(): DaylyForecasts

    @GET("/forecasts/v1/daily/5day/{id}")
    suspend fun show(@Path("id") data: Int) : Temperatura

    @POST("/forecasts/v1/daily/5day/")
    suspend fun store(@Body temperatura: Temperatura)

    @PUT("/forecasts/v1/daily/5day/")
    suspend fun update(@Body temperatura: Temperatura)

    @DELETE("/forecasts/v1/daily/5day/{id}")
    suspend fun delete(@Path("id") data: Int) : Temperatura
}