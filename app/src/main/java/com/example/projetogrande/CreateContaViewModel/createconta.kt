package com.example.projetogrande.CreateContaViewModel

import android.os.Build
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.fragment.findNavController
import com.example.projetogrande.R
import com.example.projetogrande.database.AppDb
import kotlinx.android.synthetic.main.fragment_createconta.*

class createconta : Fragment() {

    private lateinit var viewModel : ContaFormViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.fragment_createconta, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(ContaFormViewModel::class.java)

    }

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        btn_Voltar_Create_Menu.setOnClickListener {
            findNavController().navigate(R.id.action_createconta_to_menuFragment)
        }
        btn_create_list.setOnClickListener {
            findNavController().navigate(R.id.action_createconta_to_listContaFragment)
        }

        confirm.setOnClickListener {
            var nome = editTextTextPersonName3.text.toString()
            var valor = editTextNumberDecimal2.text.toString()
            var db = AppDb.getInstance(requireContext().applicationContext)
            viewModel.store(db.contaDao(), nome, valor)

            findNavController().navigate(R.id.action_createconta_to_menuFragment)
        }
    }
}