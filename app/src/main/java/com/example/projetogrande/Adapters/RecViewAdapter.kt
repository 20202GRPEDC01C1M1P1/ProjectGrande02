package com.example.projetogrande.Adapters

import android.accounts.AccountManager.get
import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowInsets.Side.all
import android.widget.Button
import android.widget.TextView
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.RecyclerView
import com.example.projetogrande.DAO.ContaDAO
import com.example.projetogrande.R
import com.example.projetogrande.ViewModels.ListViewModel
import java.lang.reflect.Array.get

class RecViewAdapter: RecyclerView.Adapter<RecViewAdapter.RecViewHolder>() {

    private final lateinit var context : Context
    private lateinit var viewModel : ListViewModel

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int): RecViewHolder {
        // Lê o XML que define um item da lista
        // e obtém uma referência para ele
        context = parent.context
        val card = LayoutInflater
            .from(context)
            .inflate(R.layout.conta_list_card, parent, false)
        return RecViewHolder(card)

    }

    override fun onBindViewHolder(holder: RecViewHolder,
                                  position: Int) {

    }


    fun mudarDados(holder: RecViewHolder, i : Int){

        bindViewHolder(holder, i)
    }


    class RecViewHolder(itemView: View):
        RecyclerView.ViewHolder(itemView){


    }

    override fun getItemCount() = 5

    }
