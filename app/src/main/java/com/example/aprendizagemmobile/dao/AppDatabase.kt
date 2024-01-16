package com.example.aprendizagemmobile.dao
import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.aprendizagemmobile.entities.Evento
import com.example.aprendizagemmobile.entities.Utilizador


@Database(entities = [Evento::class, Utilizador::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun eventoDao(): EventoDao //falta adicionar no Main Activity
    abstract fun utilizadorDao(): UtilizadorDao //falta adicionar no Main Activity

}