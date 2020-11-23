package com.example.projetogrande.ListViewModel

import androidx.lifecycle.ViewModel
import com.example.projetogrande.database.RoomDatabase
import com.example.projetogrande.models.Morador

class ListViewMoradorModel : ViewModel() {
    fun all(db: RoomDatabase): List<Morador> {
        return db.moradorDao().all().toList()
    }
}