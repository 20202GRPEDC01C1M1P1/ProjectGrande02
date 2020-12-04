package com.example.projetogrande

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import kotlinx.android.synthetic.main.fragment_menu.*

class MenuFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_menu, container, false)
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        btn_inserir_conta.setOnClickListener {
            findNavController().navigate(R.id.action_menuFragment_to_createconta)
        }
        btn_listar_conta.setOnClickListener {
            findNavController().navigate(R.id.action_menuFragment_to_listContaFragment)
        }
        btn_Criar_morador.setOnClickListener {
            findNavController().navigate(R.id.action_menuFragment_to_moradorFragment)
        }
        btn_Lista_Morador.setOnClickListener {
            findNavController().navigate(R.id.action_menuFragment_to_listMoradorFragment)
        }
        btn_temperatura.setOnClickListener {
            findNavController().navigate(R.id.action_menuFragment_to_climaFragment)
        }
    }
}