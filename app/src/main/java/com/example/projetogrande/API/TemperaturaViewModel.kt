package com.example.projetogrande.API

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class TemperaturaViewModel: ViewModel() {
    var listaTemperatura = MutableLiveData<List<Temperatura>>()
    var msg = MutableLiveData<String>()

    init {
        viewModelScope.launch{
            try {
                var temperaturas = TemperaturaInternet.getTemperaturaService().all()
                listaTemperatura.value = temperaturas!!.DailyForecasts!!.toList()
            }catch(e : Exception) {
                msg.value = e.message
            }
        }
    }
}