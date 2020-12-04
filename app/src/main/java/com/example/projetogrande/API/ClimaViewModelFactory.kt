package com.example.projetogrande.API

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class ClimaViewModelFactory : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(TemperaturaViewModel::class.java)){
            return TemperaturaViewModel() as T
        }
        else
            throw IllegalArgumentException(
                "ClimaViewModelFactory socilita um TemperaturaViewModel"
            )
    }
}