package com.example.aprendizagemmobile.templates
import androidx.recyclerview.widget.RecyclerView
import com.example.aprendizagemmobile.databinding.ItemEventoBinding
import com.example.aprendizagemmobile.entities.Evento

class EventosViewHolder(private val binding: ItemEventoBinding) :
    RecyclerView.ViewHolder(binding.root) {

    fun bind(evento: Evento) {
        binding.txtNomeEvento.text = evento.nome // titulo
        binding.textView8.text = evento.localizacao  //localizacao
        binding.textView9.text = evento.dataInicio.toString() + "/" +evento.dataFim.toString() //data
        binding.textView10.text =evento.idHorarios.toString() // hora
    }
}