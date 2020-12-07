package com.example.projetogrande.API

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class Temperatura (
    @SerializedName("Date")
    @Expose
    var date : String? = null,
    @SerializedName("Maximum")
    @Expose
    var maximum : Maximum? = null,
    @SerializedName("Minimum")
    @Expose
    var minimum: Minimum? = null,
    @SerializedName("Link")
    @Expose
    var link: String? = null
){
    inner class Minimum {
        @SerializedName("Value")
        @Expose
        var value : Double? = null
    }
    inner class Maximum{
        @SerializedName("Value")
        @Expose
        var value : Double? = null
    }
}