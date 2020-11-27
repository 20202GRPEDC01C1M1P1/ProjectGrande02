package com.example.projetogrande.models

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey
import com.google.firebase.firestore.DocumentId

@Entity
data class Morador (
    var nomeMorador: String,
    var apartamento: String,
    var numeroApartamento: String,
    @PrimaryKey(autoGenerate = true)
    @DocumentId
    var idMorador: Int? = null
)