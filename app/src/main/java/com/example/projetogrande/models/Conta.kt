package com.example.projetogrande.models

import androidx.annotation.NonNull
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey
import com.google.firebase.firestore.DocumentId


@Entity
data class Conta(
    var nome: String,
    var valor: String,
    @DocumentId @NonNull var idConta: String? = null,
    @ForeignKey(entity = Morador::class,
        parentColumns = ["id"],
        childColumns = ["condId"])
    var condId : Int? = null
)
