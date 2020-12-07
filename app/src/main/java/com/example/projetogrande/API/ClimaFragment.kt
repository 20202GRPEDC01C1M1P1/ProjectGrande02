package com.example.projetogrande.API

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.observe
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.projetogrande.Adapters.RecViewTemperaturaAdapter
import com.example.projetogrande.R
import kotlinx.android.synthetic.main.fragment_clima.*

class ClimaFragment : Fragment() {

    private lateinit var listViewModel : TemperaturaViewModel
    private lateinit var listViewModelFactory : ClimaViewModelFactory

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        listViewModelFactory = ClimaViewModelFactory()
        listViewModel = ViewModelProvider(this, listViewModelFactory).get(TemperaturaViewModel::class.java)

        val root = inflater.inflate(R.layout.fragment_clima, container, false)

        listViewModel
            .listaTemperatura
            .observe(viewLifecycleOwner){
                idListView.adapter = RecViewTemperaturaAdapter(
                    listViewModel.listaTemperatura.value!!
                )
                idListView.layoutManager = LinearLayoutManager(requireContext())
            }
        return root
    }
}