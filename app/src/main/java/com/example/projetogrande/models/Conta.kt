package com.example.projetogrande.models

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey


@Entity
data class Conta(
    var nome: String,
    var valor: String,
    @PrimaryKey(autoGenerate = true)
    var idConta: Int? = null,
    @ForeignKey(entity = Condomino::class,
        parentColumns = ["id"],
        childColumns = ["condId"])
    var condId : Int? = null
)
