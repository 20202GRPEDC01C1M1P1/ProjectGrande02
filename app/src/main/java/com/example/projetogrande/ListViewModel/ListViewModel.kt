package com.example.projetogrande.ListViewModel

import androidx.lifecycle.ViewModel
import com.example.projetogrande.database.RoomDatabase
import com.example.projetogrande.models.Conta

class ListViewModel : ViewModel() {
    fun all(db: RoomDatabase): List<Conta> {
        return db.contaDao().all().toList()
    }
}