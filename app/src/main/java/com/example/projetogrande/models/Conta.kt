package com.example.projetogrande.models

import com.google.firebase.firestore.DocumentId


class Conta(
    var nome: String? = null,
    var valor: String? = null,
    @DocumentId
    var id : String? = null
)

