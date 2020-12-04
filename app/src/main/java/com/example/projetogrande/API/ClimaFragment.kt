package com.example.projetogrande.API

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.observe
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
                idListView.adapter = ArrayAdapter(
                    requireContext(),
                    android.R.layout.simple_list_item_1,
                    it
                )
            }
        return root
    }
}