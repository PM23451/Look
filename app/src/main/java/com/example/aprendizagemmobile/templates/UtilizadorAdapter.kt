package com.example.aprendizagemmobile.templates

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.aprendizagemmobile.R
import com.example.aprendizagemmobile.entities.Utilizador

class UtilizadorAdapter(private val utilizadores: List<Utilizador> ):

    RecyclerView.Adapter<UtilizadorAdapter.UtilizadorViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UtilizadorViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.activity_main, parent, false)
        return UtilizadorViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: UtilizadorViewHolder, position: Int) {
        val utilizador = utilizadores[position]

        // Atualize as visualizações do item com os dados do evento

        //Email_Textinput

        holder.txtEmail.text = utilizador.email
        // Adicione outras atualizações conforme necessário

        // Defina cliques ou outras ações do item aqui
        holder.button.setOnClickListener {
            // Ação do botão
        }
    }

    override fun getItemCount(): Int {
        return utilizadores.size
    }



    class UtilizadorViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val txtEmail: TextView = itemView.findViewById(R.id.Email_Textinput)
        val button: Button = itemView.findViewById(R.id.Login)
        // Adicione outras visualizações do item conforme necessário
    }
}

