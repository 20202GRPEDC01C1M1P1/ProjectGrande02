package com.example.projetogrande.CreateContaViewModel

import android.os.Build
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.fragment.findNavController
import com.example.projetogrande.R
import com.example.projetogrande.ViewModels.ContaViewmodel
import com.example.projetogrande.models.Conta
import kotlinx.android.synthetic.main.fragment_createconta.*

public final class createconta : Fragment() {

    private lateinit var viewModel : ContaFormViewModel
    private lateinit var contaViewModel : ContaViewmodel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.fragment_createconta, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        activity?.let {
            contaViewModel = ViewModelProviders.of(it)
                .get(ContaViewmodel::class.java)
            if (contaViewModel.conta != null){
                var conta = contaViewModel.conta
                addInputInfo(conta)
            }
        }
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
            var conta = Conta(nome,valor)

            if (contaViewModel.conta?.id != null) {
                contaViewModel.conta!!.nome = nome
                contaViewModel.conta!!.valor = valor
                viewModel.update(contaViewModel.conta!!)
                    .addOnSuccessListener {
                        Toast.makeText(
                            requireContext(),
                            "Conta alterada",
                            Toast.LENGTH_LONG
                        ).show()
                        findNavController().popBackStack()
                    }
                    .addOnFailureListener {
                        Toast.makeText(
                            requireContext(),
                            it.message,
                            Toast.LENGTH_LONG
                        ).show()
                    }

            } else {
                viewModel.store(conta)
                    .addOnSuccessListener {
                        Toast.makeText(
                            requireContext(),
                            "Conta adicionada",
                            Toast.LENGTH_LONG
                        ).show()
                        findNavController().popBackStack()
                    }
                    .addOnFailureListener {
                        Toast.makeText(
                            requireContext(),
                            it.message,
                            Toast.LENGTH_LONG
                        ).show()
                    }
            }
        }

        deleteButton.setOnClickListener{
            viewModel.delete(contaViewModel.conta!!)
                .addOnSuccessListener {
                    Toast.makeText(
                        requireContext(),
                        "Conta deletada",
                        Toast.LENGTH_LONG
                    ).show()
                    findNavController().popBackStack()
                }
                .addOnFailureListener {
                    Toast.makeText(
                        requireContext(),
                        it.message,
                        Toast.LENGTH_LONG
                    ).show()
                }
        }
    }
    private fun addInputInfo(conta: Conta?) {
        editTextNumberDecimal2.setText(conta?.valor)
        editTextTextPersonName3.setText(conta?.nome)

        deleteButton.isEnabled = true
        deleteButton.visibility = View.VISIBLE
    }
}