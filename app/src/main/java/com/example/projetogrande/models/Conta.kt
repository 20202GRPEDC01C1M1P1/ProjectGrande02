package com.example.projetogrande.models

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.sql.Date
import java.time.LocalDate
import java.util.*

@Entity
data class Conta(
    var nome: String,
    var valor: Double,
    var data: LocalDate,
    @PrimaryKey var id: Int? = null
)
