package com.example.projetogrande.ListViewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class ListViewModelFactory : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(ListViewModel::class.java)){
            return ListViewModel() as T
        } else
            throw IllegalArgumentException(
                "ListViewModelFactory socilita um ListViewModel"
            )
    }
}