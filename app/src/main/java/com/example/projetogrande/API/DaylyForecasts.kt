package com.example.projetogrande.API

import com.google.gson.annotations.SerializedName

data class DaylyForecasts
    (
    @SerializedName("DaylyForecasts")
        var DaylyForecasts : List<Temperatura>? = null
    )