package com.example.projetogrande.API

import androidx.lifecycle.LiveData
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
                listaTemperatura.value = temperaturas!!.temperaturas
            }catch(e : Exception) {
                msg.value = e.message
            }
        }

       /* call.enqueue(
            object : Callback<Temperaturas>{
                override fun onResponse(call: Call<Temperaturas>, response: Response<Temperaturas>)
                {
                    var temperaturas = response.body()

                }

                override fun onFailure(call: Call<Temperaturas>, t: Throwable) {

                }

            }
        )*/
    }
}