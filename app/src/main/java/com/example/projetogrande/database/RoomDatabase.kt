package com.example.projetogrande.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.projetogrande.DAO.CondominoDAO
import com.example.projetogrande.DAO.ContaDAO
import com.example.projetogrande.DAO.MoradorDAO
import com.example.projetogrande.models.Condomino
import com.example.projetogrande.models.Conta
import com.example.projetogrande.models.Morador


@Database(
    entities = arrayOf(
        Condomino::class,
        Conta::class,
        Morador::class
    ),
    version = 2
)
abstract class RoomDatabase : RoomDatabase() {
    abstract fun condominoDao() : CondominoDAO
    abstract fun contaDao() : ContaDAO
    abstract  fun moradorDao(): MoradorDAO
}