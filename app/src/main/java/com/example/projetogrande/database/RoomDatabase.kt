package com.example.projetogrande.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.projetogrande.DAO.CondominoDAO
import com.example.projetogrande.DAO.ContaDAO
import com.example.projetogrande.models.Condomino
import com.example.projetogrande.models.Conta


@Database(
    entities = arrayOf(
        Condomino::class,
        Conta::class
    ),
    version = 1
)
abstract class RoomDatabase : RoomDatabase() {
    abstract fun condominoDao() : CondominoDAO
    abstract fun contaDao() : ContaDAO
}