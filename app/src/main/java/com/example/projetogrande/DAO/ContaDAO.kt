package com.example.projetogrande.DAO

import androidx.room.*
import com.example.projetogrande.models.Conta
import java.sql.Date
import java.util.*

@Dao
interface ContaDAO {
    @Insert
    fun store(conta: Conta)
    @Update
    fun update(conta: Conta)
    @Delete
    fun delete(conta: Conta)

    @Query("SELECT * FROM Conta")
    fun all(): Array<Conta>
    @Query("SELECT * FROM Conta WHERE id = :indicador")
    fun show(indicador: Int): Array<Conta>
    @Query("SELECT * FROM Conta WHERE MONTH(Data) = MONTH(:indicador) AND YEAR(Data) = YEAR(:indicador)")
    fun pegaContaDt(indicador: Date): Array<Conta>
}
