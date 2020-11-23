package com.example.projetogrande.ListViewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class ListViewModelFactory : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(ListViewContaModel::class.java)){
            return ListViewContaModel() as T
        }
        if (modelClass.isAssignableFrom(ListViewMoradorModel::class.java)){
            return ListViewMoradorModel() as T
        }
        else
            throw IllegalArgumentException(
                "ListViewModelFactory socilita um ListViewModel"
            )
    }
}