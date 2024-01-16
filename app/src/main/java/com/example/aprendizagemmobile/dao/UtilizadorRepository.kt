package com.example.aprendizagemmobile.dao
import com.example.aprendizagemmobile.entities.Utilizador
import com.example.aprendizagemmobile.dao.UtilizadorDao
class UtilizadorRepository(private val UtilizadorDao: UtilizadorDao)
{
    suspend fun inserirUtilizador(utilizador: Utilizador) {
        UtilizadorDao.inserir(utilizador)
    }

    suspend fun listarUtilizador(): List<Utilizador> {
        return UtilizadorDao.listarUtilizadores()
    }
    suspend fun apagarUtilizador(utilizador: Utilizador) {
        UtilizadorDao.apagar(utilizador)
    }
}
