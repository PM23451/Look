package com.example.aprendizagemmobile.entities
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale


@Entity(tableName = "Eventos")
data class Evento(
    @PrimaryKey(autoGenerate = true) val id: Long = 0,
    val nome: String,
    val localizacao: String,
    val dataInicio: String,
    val idHorarios : Int,
    val dataFim : String,
    val preco: Float,
    val descricao: String,
    val gratuito: Boolean
) {
    fun formatarHorarioInicio(): String {
        // Converter a string para Date
        val sdf = SimpleDateFormat("dd MMMM yyyy", Locale.getDefault())
        val horarioInicioDate = sdf.parse(dataInicio)
        // Formatar a data
        return sdf.format(horarioInicioDate)
    }

    fun formatarHorarioFim(): String {
        // Converter a string para Date
        val sdf = SimpleDateFormat("dd MMMM yyyy", Locale.getDefault())
        val horarioFimDate = sdf.parse(dataFim)
        // Formatar a data
        return sdf.format(horarioFimDate)
    }
}