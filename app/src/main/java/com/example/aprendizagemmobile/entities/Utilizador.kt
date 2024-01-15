package com.example.aprendizagemmobile.entities
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Utilizador")
data class Utilizador(
    @PrimaryKey(autoGenerate = true) val id: Long = 0,
    val nome: String,
    val email: String,
    val password: String,
    val passwordConfirm: String,
    )