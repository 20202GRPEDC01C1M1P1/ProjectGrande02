package com.example.projetogrande.ListViewModel

import androidx.lifecycle.ViewModel
import com.example.projetogrande.database.RoomDatabase
import com.example.projetogrande.models.Conta
import com.google.android.gms.tasks.Task
import com.google.firebase.firestore.CollectionReference
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.QuerySnapshot

class ListViewContaModel : ViewModel() {
    fun all(): CollectionReference {
        var db = FirebaseFirestore.getInstance()
            .collection("contas")
        return db
    }
}