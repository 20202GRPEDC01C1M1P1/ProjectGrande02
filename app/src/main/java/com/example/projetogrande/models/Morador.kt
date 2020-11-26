package com.example.projetogrande.models

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity
data class Morador (
    var nomeMorador: String,
    var apartamento: String,
    var numeroApartamento: String,
    @PrimaryKey(autoGenerate = true)
    var idMorador: Int? = null,
    @ForeignKey(entity = Condomino::class,
        parentColumns = ["id"],
        childColumns = ["moraId"])
    var moraId : Int? = null
)