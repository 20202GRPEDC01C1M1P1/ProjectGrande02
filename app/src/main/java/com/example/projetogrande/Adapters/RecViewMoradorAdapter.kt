package com.example.projetogrande.Adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.projetogrande.R
import com.example.projetogrande.models.Morador
import kotlinx.android.synthetic.main.recycle_view_morador_source.view.*

class RecViewMoradorAdapter (
    private val listaMorador: List<Morador>
)
    : RecyclerView.Adapter<RecViewMoradorAdapter.MoradorViewHolder>()
{

    class MoradorViewHolder(itemView: View):
        RecyclerView.ViewHolder(itemView) {
        val viewApartamento : TextView =  itemView.textViewMorador
        val viewNomeMorador  : TextView = itemView.textViewNumeroApt
        val viewNumeroApartamento : TextView = itemView.textViewNomeApt
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MoradorViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.recycle_view_morador_source, parent, false)
        val moradorViewHolder = MoradorViewHolder(view)
        return  moradorViewHolder
    }

    override fun onBindViewHolder(holder: MoradorViewHolder, position: Int) {
        val morador = listaMorador[position]
        holder.viewNomeMorador.text = morador.nomeMorador
        holder.viewNumeroApartamento.text = morador.numeroApartamento
        holder.viewApartamento.text = morador.apartamento
    }
    override fun getItemCount(): Int = listaMorador.size
}