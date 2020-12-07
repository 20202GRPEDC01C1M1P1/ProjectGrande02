package com.example.projetogrande.models

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.firebase.firestore.DocumentId

@Entity
data class Morador (
    var nomeMorador: String,
    var apartamento: String,
    var numeroApartamento: String,
    @PrimaryKey(autoGenerate = true)
    var idMorador: Int? = null
)