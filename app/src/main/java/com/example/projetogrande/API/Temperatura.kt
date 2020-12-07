package com.example.projetogrande.API

class Temperatura (
    var date : String? = null,
    var maximum : Maximum? = null,
    var minimum: Minimum? = null,
    var link: String? = null
){
    inner class Minimum {
        var value : Double? = null
    }
    inner class Maximum{
        var value : Double? = null
    }
}