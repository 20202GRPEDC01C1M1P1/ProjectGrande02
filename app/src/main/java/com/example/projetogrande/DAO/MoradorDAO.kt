package com.example.projetogrande.DAO

import androidx.room.*
import com.example.projetogrande.models.Morador
@Dao
interface MoradorDAO {
    @Insert
    fun store(morador: Morador)

    @Update
    fun update(morador: Morador)

    @Delete
    fun delete(morador: Morador)

    @Query("SELECT * FROM Morador")
    fun all(): List<Morador>

    @Query("SELECT * FROM Morador WHERE idMorador = :indicador")
    fun show(indicador: Int): List<Morador>
}