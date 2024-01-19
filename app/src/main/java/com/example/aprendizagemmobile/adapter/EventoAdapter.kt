package com.example.aprendizagemmobile.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.aprendizagemmobile.R

class EventoAdapter(private var eventos: List<com.example.aprendizagemmobile.entities.Evento>) : RecyclerView.Adapter<EventoAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_evento, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val evento = eventos[position]

        holder.txtNomeEvento.text = evento.nome
        holder.txtLocalEvento.text = evento.localizacao
        holder.txtDataEvento.text = evento.dataInicio
        holder.txtHorario.text = evento.idHorarios.toString()
        //Guardar o id do evento no botão para ir para o ecrã de detalhes
        holder.botao.id = evento.id.toInt()
        if(evento.gratuito == true){
            holder.botao.text = "Gratuito"
        }else{
            holder.botao.text = evento.preco.toString()
        }


        /*Glide.with(holder.itemView)
            .load(country.flags.png)
            .into(holder.countryFlag)*/
    }

    override fun getItemCount(): Int {
        return eventos.size
    }

    fun updateEventos(newEventos: List<com.example.aprendizagemmobile.entities.Evento>) {
        eventos = newEventos
        notifyDataSetChanged()
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val txtNomeEvento: TextView = itemView.findViewById(R.id.txtNomeEvento)
        val txtLocalEvento: TextView = itemView.findViewById(R.id.textView8)
        val txtDataEvento: TextView = itemView.findViewById(R.id.textView9)
        val txtHorario: TextView = itemView.findViewById(R.id.textView10)
        val botao: TextView = itemView.findViewById(R.id.button)
    }
}