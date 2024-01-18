package com.example.aprendizagemmobile.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.example.aprendizagemmobile.entities.Utilizador

@Dao
interface UtilizadorDao {

    // Inserir um novo Utilizador
    @Insert
    suspend fun inserir(utilizador: Utilizador)

    // Obter a lista de todos os Utilizadores
    @Query("SELECT * FROM Utilizador")
    suspend fun listarUtilizadores(): List<Utilizador>

    // Realizar login e retornar o Utilizador correspondente se as credenciais estiverem corretas
    @Query("SELECT * FROM Utilizador WHERE email = :email AND password = :password")
    suspend fun login(email: String, password: String): Utilizador?

    // Apagar um Utilizador
    @Delete
    suspend fun apagar(utilizador: Utilizador)

    // Função para realizar a autenticação de login
    // ...

}


