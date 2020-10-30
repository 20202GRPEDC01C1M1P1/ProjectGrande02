package com.example.projetogrande.models

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey
import java.sql.Date
import java.time.LocalDate
import java.util.*

@Entity
data class Conta(
    var nome: String,
    var valor: Double,
    var data: LocalDate,
    @PrimaryKey(autoGenerate = true)
    var idConta: Int? = null,
    @ForeignKey(entity = Condomino::class,
        parentColumns = ["id"],
        childColumns = ["condId"])
    var condId : Int? = null
)
