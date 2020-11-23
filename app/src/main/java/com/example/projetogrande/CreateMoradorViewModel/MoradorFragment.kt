package com.example.projetogrande.CreateMoradorViewModel

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
import kotlinx.android.synthetic.main.fragment_morador.*

class MoradorFragment : Fragment() {

    private lateinit var viewModel : CreateMoradorFormViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_morador, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(CreateMoradorFormViewModel::class.java)
    }

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        btn_retorno_menu.setOnClickListener {
            findNavController().navigate(R.id.action_moradorFragment_to_menuFragment)
        }
        btn_morador_list.setOnClickListener {
            findNavController().navigate(R.id.action_moradorFragment_to_listMoradorFragment)
        }

        confirmarMorador.setOnClickListener {
            var morador = editTextNomeMorador.text.toString()
            var apartamento = editTextApartamento.text.toString()
            var numeroApt = editTextNumeroApt.text.toString()
            var db = AppDb.getInstance(requireContext().applicationContext)
            viewModel.store(db.moradorDao(), morador, apartamento,numeroApt)

            findNavController().navigate(R.id.action_moradorFragment_to_listMoradorFragment)
        }
    }
}