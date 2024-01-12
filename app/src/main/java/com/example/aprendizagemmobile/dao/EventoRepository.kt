package com.example.aprendizagemmobile.dao
import com.example.aprendizagemmobile.entities.Evento


class EventoRepository(private val eventoDao: EventoDao)
{
    suspend fun inserirEvento(evento: Evento) {
        eventoDao.inserir(evento)
    }

    suspend fun listarEvento(): List<Evento> {
        return eventoDao.listarEventos()
    }
    suspend fun apagarEvento(evento: Evento) {
        eventoDao.apagar(evento)
    }
}