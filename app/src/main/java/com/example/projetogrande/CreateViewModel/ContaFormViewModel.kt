package com.example.projetogrande.CreateViewModel

import androidx.lifecycle.ViewModel
import com.example.projetogrande.DAO.ContaDAO
import com.example.projetogrande.models.Conta

class ContaFormViewModel : ViewModel() {
    fun store(
        contaDAO: ContaDAO,
        nome: String,
        valor: String
    ) {
        var conta = Conta(nome, valor)
        contaDAO.store(conta)
    }
}
