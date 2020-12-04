package com.example.projetogrande.Adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.projetogrande.API.Temperatura
import com.example.projetogrande.R
import kotlinx.android.synthetic.main.clima_lista_item.view.*

class RecViewTemperaturaAdapter (
    private val listaTemperatura: List<Temperatura>
)
    : RecyclerView.Adapter<RecViewTemperaturaAdapter.TemperaturaViewHolder>()
{

    class TemperaturaViewHolder(itemView: View):
        RecyclerView.ViewHolder(itemView) {
        val viewTemperaturaMaxima : TextView =  itemView.tvHighTemperature
        val viewTemperaturaMinima  : TextView = itemView.tvLowTemperature
        val viewLink : TextView = itemView.tvLink
        val viewDate : TextView = itemView.tvDate
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TemperaturaViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.clima_lista_item, parent, false)
        val temperaturaViewHolder = TemperaturaViewHolder(view)
        return  temperaturaViewHolder
    }

    override fun onBindViewHolder(holder: TemperaturaViewHolder, position: Int) {
        val temperatura = listaTemperatura[position]
        holder.viewTemperaturaMaxima.text = temperatura.maxTemp
        holder.viewTemperaturaMinima.text = temperatura.minTemp
        holder.viewLink.text = temperatura.link
        holder.viewDate.text = temperatura.date
    }
    override fun getItemCount(): Int = listaTemperatura.size
}