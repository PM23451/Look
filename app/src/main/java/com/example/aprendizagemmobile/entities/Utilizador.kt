package com.example.aprendizagemmobile.entities
import android.provider.ContactsContract.CommonDataKinds.Email
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.net.PasswordAuthentication

@Entity(tableName = "Utilizador")
data class Utilizador(
    @PrimaryKey(autoGenerate = true) val id: Long = 0,
    val nome: String,
    val email: Email,
    val passwordAuthentication: PasswordAuthentication,
)