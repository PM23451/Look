package com.example.aprendizagemmobile.entities

import androidx.room.Entity
import androidx.room.PrimaryKey



@Entity(tableName = "Programacao")
data class Programacao(
    @PrimaryKey(autoGenerate = true) val id: Long = 0,
    val horaInicio: String,
    val horaFim: String,
    val localizacaoEspecifica: String,
    val descricao: String,
)