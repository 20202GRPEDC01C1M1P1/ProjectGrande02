package com.example.projetogrande.DAO

import androidx.room.*
import com.example.projetogrande.models.Conta

@Dao
interface ContaDAO {
    @Insert
    fun store(conta: Conta)
    @Update
    fun update(conta: Conta)
    @Delete
    fun delete(conta: Conta)

    @Query("SELECT * FROM Conta")
    fun all(): List<Conta>
    @Query("SELECT * FROM Conta WHERE idConta = :indicador")
    fun show(indicador: Int): List<Conta>

  //  @Query("SELECT * FROM Conta WHERE MONTH(Data) = MONTH(:indicador) AND YEAR(Data) = YEAR(:indicador)")
  //  fun pegaContaDt(indicador: Date): Array<Conta>
}