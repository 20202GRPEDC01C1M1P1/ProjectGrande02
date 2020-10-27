package com.example.projetogrande.ViewModels

import androidx.lifecycle.ViewModel
import com.example.projetogrande.database.RoomDatabase
import com.example.projetogrande.models.Conta

class ListViewModel : ViewModel() {
    fun all(db: RoomDatabase): Array<Conta> {
        return db.contaDao().all()
    }
}