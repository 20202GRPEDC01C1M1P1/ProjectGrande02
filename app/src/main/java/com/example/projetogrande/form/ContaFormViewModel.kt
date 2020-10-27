package com.example.projetogrande.form

import androidx.lifecycle.ViewModel
import com.example.projetogrande.DAO.ContaDAO
import com.example.projetogrande.models.Conta
import java.sql.Date
import java.time.LocalDate

class ContaFormViewModel : ViewModel() {
    fun store(
        contaDAO: ContaDAO,
        nome: String,
        valor: Double,
        data: LocalDate
    ) {
        var conta = Conta(nome, valor, data)
        contaDAO.store(conta)
    }
}
