package com.example.aprendizagemmobile

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import androidx.room.Room
import com.example.aprendizagemmobile.dao.AppDatabase
import com.example.aprendizagemmobile.templates.UtilizadorAdapter

class MainActivity : AppCompatActivity() {

    val database = Room.databaseBuilder(
        applicationContext,
        AppDatabase::class.java,
        "eventos-db"
    ).build()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val toHome: Button = findViewById(R.id.Login)
        toHome.setOnClickListener {
            startActivity(Intent(this, Home::class.java))
        }

        val btnLogin: Button = findViewById(R.id.Login)
        btnLogin.setOnClickListener {
            // Obtém os valores do email e senha dos campos de entrada
            val email = findViewById<EditText>(R.id.Email_Textinput).text.toString()
            val senha = findViewById<EditText>(R.id.Password_Textinput).text.toString()

            // Chama a função de login no ViewModel
            UtilizadorAdapter.realizarLogin(email, senha)
        }
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