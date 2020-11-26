package com.example.projetogrande.models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
class Condomino(
    var nome: String,
    @PrimaryKey(autoGenerate = true)
    var id: Int? = null
)