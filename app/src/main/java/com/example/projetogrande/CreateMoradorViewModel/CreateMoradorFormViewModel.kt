package com.example.projetogrande.CreateMoradorViewModel

import androidx.lifecycle.ViewModel
import com.example.projetogrande.DAO.MoradorDAO
import com.example.projetogrande.models.Morador

class CreateMoradorFormViewModel : ViewModel() {
    fun store(
        moradorDao: MoradorDAO,
        nomeMorador: String,
        apartamento: String,
        numeroApartamento: String
    ) {
        var morador = Morador(nomeMorador, apartamento, numeroApartamento)
        moradorDao.store(morador)
    }
}