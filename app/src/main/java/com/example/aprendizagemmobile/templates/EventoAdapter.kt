package com.example.aprendizagemmobile.templates
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView

import androidx.recyclerview.widget.RecyclerView
import com.example.aprendizagemmobile.R
import com.example.aprendizagemmobile.entities.Evento

//EventoAdapter.kt
class EventoAdapter(private val eventos: List<Evento>) :
    RecyclerView.Adapter<EventoAdapter.EventoViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EventoViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_evento, parent, false)
        return EventoViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: EventoViewHolder, position: Int) {
        val evento = eventos[position]

        // Atualize as visualizações do item com os dados do evento
        holder.txtNomeEvento.text = evento.nome
        // Adicione outras atualizações conforme necessário

        // Defina cliques ou outras ações do item aqui
        holder.button.setOnClickListener {
            // Ação do botão
        }
    }


    override fun getItemCount(): Int {
        return eventos.size
    }

    class EventoViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val txtNomeEvento: TextView = itemView.findViewById(R.id.txtNomeEvento)
        val button: Button = itemView.findViewById(R.id.button)
        // Adicione outras visualizações do item conforme necessário
    }
}



