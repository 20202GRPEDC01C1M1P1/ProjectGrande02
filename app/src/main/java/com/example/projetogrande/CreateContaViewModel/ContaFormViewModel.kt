package com.example.projetogrande.CreateContaViewModel

import androidx.lifecycle.ViewModel
import com.example.projetogrande.models.Conta
import com.google.android.gms.tasks.Task
import com.google.firebase.firestore.FirebaseFirestore

class ContaFormViewModel : ViewModel() {
    fun store(conta: Conta): Task<Void> {
        var db = FirebaseFirestore.getInstance()

        val id = db
            .collection("contas")
            .document()

        conta.id = id.toString()

        var task = db
            .collection("contas")
            .document(conta.id!!)
            .set(conta)
        return task
    }

    fun delete(conta: Conta): Task<Void> {
        var db = FirebaseFirestore.getInstance()
        var task = db
            .collection("contas")
            .document(conta.id!!)
            .delete()
        return task
    }
}
