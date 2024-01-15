package com.example.aprendizagemmobile.dao
import com.example.aprendizagemmobile.entities.Evento
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
interface EventoDao
{
    @Insert
    suspend fun inserir(evento: Evento)

    @Query("SELECT * FROM eventos")
    suspend fun listarEventos(): List<Evento>

    @Delete
    suspend fun apagar(evento: Evento)
}
