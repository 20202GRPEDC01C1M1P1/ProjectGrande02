package com.example.projetogrande.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.projetogrande.DAO.ContaDAO
import com.example.projetogrande.DAO.MoradorDAO
import com.example.projetogrande.models.Conta
import com.example.projetogrande.models.Morador


@Database(
    entities = arrayOf(
        Conta::class,
        Morador::class
    ),
    version = 2
)
abstract class RoomDatabase : RoomDatabase() {
    abstract fun contaDao() : ContaDAO
    abstract  fun moradorDao(): MoradorDAO
}