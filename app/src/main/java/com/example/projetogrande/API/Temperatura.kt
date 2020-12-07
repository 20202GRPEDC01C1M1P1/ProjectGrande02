package com.example.projetogrande.API

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class Temperatura (
    @SerializedName("Date")
    @Expose
    var date : String? = null,
    @SerializedName("Temperature")
    @Expose
    var temperature: Temperature? = null,
    @SerializedName("Link")
    @Expose
    var link: String? = null
){
    inner class Temperature{
        @SerializedName("Maximum")
        @Expose
        var maximum : Maximum? = null
        @SerializedName("Minimum")
        @Expose
        var minimum : Minimum? = null
    }
    inner class Minimum {
        @SerializedName("Value")
        @Expose
        var value : String? = null
    }
    inner class Maximum{
        @SerializedName("Value")
        @Expose
        var value : String? = null
    }
}