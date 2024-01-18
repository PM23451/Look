package com.example.aprendizagemmobile.dao
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.example.aprendizagemmobile.entities.Evento

@Dao
interface EventoDao
{
    @Insert
    suspend fun inserir(evento: Evento)

    @Query("SELECT * FROM Eventos")
    suspend fun listarEventos(): List<Evento>

    @Delete
    suspend fun apagar(evento: Evento)

}

/*val novoEvento = Evento(
    nome = "Nome do Evento",
    localizacao = "Aveiro",
    dataInicio = "01 Janeiro 2024",  // Substitua com sua data real
    idHorarios = 1,  // Substitua com seu ID de horário real
    dataFim = "03 Janeiro 2024",  // Substitua com sua data real
    preco = 20.0,  // Substitua com seu preço real
    descricao = "Descrição do Evento",
    gratuito = false
)*/

// Em uma coroutine, por exemplo:
/*viewModelScope.launch {
    EventoDao.inserir(novoEvento)
}*/
