package com.example.aprendizagemmobile.repositorio

import com.example.aprendizagemmobile.entities.Evento

class eventsRepo
{

    private val EventModel = ArrayList<Evento>()

    init {
        EventModel.add(Evento(1, "Feira da agonia", "Viana do castilho", "12-08-2024",1,"18-08-2024",0.0,"Feira da agonia vai tar evento de bolas de berlinde",true))
        EventModel.add(Evento(2, "Viana joga forte", "Setubal", "1-02-2024",3,"5-02-2024",1.1,"Vi ter jogos de tabuleiro infinitos",false))
        EventModel.add(Evento(3, "Festa da cerveja e do marisco", "Fao", "10-08-2024",3,"24-08-2024",10.0,"Tem cerveja e Marisco para morrer engasgado",false))
    }
    companion object {
        private var eventsRepo: eventsRepo? = null

        @JvmStatic
        fun getEventsRepo(): eventsRepo {
            if (eventsRepo == null) {
                eventsRepo = eventsRepo()
            }
            return eventsRepo as eventsRepo
        }
    }

    fun getEventModelList(): ArrayList<Evento> {
        return EventModel
    }
}