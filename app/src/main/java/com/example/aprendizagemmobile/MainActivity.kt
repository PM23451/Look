package com.example.aprendizagemmobile

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.room.Room
import com.example.aprendizagemmobile.dao.AppDatabase

class MainActivity : AppCompatActivity() {

    private lateinit var database: AppDatabase
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        database = Room.databaseBuilder(
            applicationContext,
            AppDatabase::class.java,
            "eventos-db"
        ).build()

        /*val toHome: Button = findViewById(R.id.Login)
        toHome.setOnClickListener {
            startActivity(Intent(this, Home::class.java))
        }*/
    }

    fun navegarParaRegisto(view: View) {
        val intent = Intent(this, Registo::class.java)
        startActivity(intent)
    }

    fun login(view: View) {
        val intent = Intent(this, Home::class.java)
        startActivity(intent)
    }





}