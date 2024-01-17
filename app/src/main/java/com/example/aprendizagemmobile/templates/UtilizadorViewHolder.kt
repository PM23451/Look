package com.example.aprendizagemmobile.templates
import androidx.recyclerview.widget.RecyclerView
import com.example.aprendizagemmobile.databinding.ActivityMainBinding
import com.example.aprendizagemmobile.entities.Utilizador

class UtilizadorViewHolder(private val binding: ActivityMainBinding) :
    RecyclerView.ViewHolder(binding.root) {

    fun bind(utilizador: Utilizador) {
        binding.EmailTextinput.text = utilizador.email // titulo
        binding.PasswordTextinput.text = utilizador.password  //localizacao

    }
}