package com.example.projetogrande.API

import retrofit2.http.*

interface TemperaturaService {

    @GET("/alarms/v1/5day/2154564")
    suspend fun all(@Query("apikey") apikey: String = "E8p1hJDqVru7jmDyf1EwElm5NNwUFPlt"): Temperaturas

    @GET("/forecasts/v1/daily/5day/{id}")
    suspend fun show(@Path("id") data: Int) : Temperatura

    @POST("/forecasts/v1/daily/5day/")
    suspend fun store(@Body temperatura: Temperatura)

    @PUT("/forecasts/v1/daily/5day/")
    suspend fun update(@Body temperatura: Temperatura)

    @DELETE("/forecasts/v1/daily/5day/{id}")
    suspend fun delete(@Path("id") data: Int) : Temperatura
}