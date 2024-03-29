package com.example.aprendizagemmobile.dao
import android.content.Context
import androidx.room.Room

class Application(context: Context) {
    val db = Room.databaseBuilder(
        context,
        AppDatabase::class.java, "lookBD"
    ).build()

    val eventoDatabase = AppDatabase.getDatabase(context)
    val eventoDao = eventoDatabase.eventoDao()

}
