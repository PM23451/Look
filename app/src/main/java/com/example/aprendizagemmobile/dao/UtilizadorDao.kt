package com.example.aprendizagemmobile.dao
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.example.aprendizagemmobile.entities.Utilizador

@Dao
interface UtilizadorDao
{
    @Insert
    suspend fun inserir(utilizador: Utilizador)

    @Query("SELECT * FROM Utilizador")
    suspend fun listarUtilizadores(): List<Utilizador>

    @Delete
    suspend fun apagar(utilizador: Utilizador)
}