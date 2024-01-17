package com.example.aprendizagemmobile.dao
import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.aprendizagemmobile.entities.Evento
import com.example.aprendizagemmobile.entities.Utilizador


@Database(entities = [Evento::class, Utilizador::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun eventoDao(): EventoDao //falta adicionar no Main Activity
    abstract fun utilizadorDao(): UtilizadorDao //falta adicionar no Main Activity

    companion object {
        @Volatile
        private var INSTANCE: AppDatabase? = null

        fun getDatabase(context: Context): AppDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    "lookdb"  // Nome da sua base de dados
                ).build()
                INSTANCE = instance
                instance
            }
        }
    }
}