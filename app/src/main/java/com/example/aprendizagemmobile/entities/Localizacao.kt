package com.example.aprendizagemmobile.entities

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.aprendizagemmobile.model.Cidades

@Entity(tableName = "localizacao")
data class Localizacao(
    @PrimaryKey(autoGenerate = true) val id: Long = 0,
    val cidades: Cidades,
)