package com.example.aprendizagemmobile.templates
import com.example.aprendizagemmobile.entities.Utilizador
import androidx.recyclerview.widget.RecyclerView
//import com.example.aprendizagemmobile.databinding.ItemAlunoBinding
class UtilizadorViewHolder(private val binding: ) :
    RecyclerView.ViewHolder(binding.root) {

    fun bind(utilizador: Utilizador) {
        binding.Email_Textinput.text = utilizador.email // titulo
        binding.Password_Textinput.text = utilizador.password  //localizacao

    }
}