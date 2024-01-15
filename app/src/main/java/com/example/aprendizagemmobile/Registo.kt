package com.example.aprendizagemmobile

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import androidx.lifecycle.lifecycleScope
import androidx.room.Room
import com.example.aprendizagemmobile.dao.AppDatabase
import com.example.aprendizagemmobile.dao.UtilizadorRepository
import com.example.aprendizagemmobile.entities.Utilizador
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext


class Registo : AppCompatActivity() {

    private lateinit var UtilizadorRepository: UtilizadorRepository

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registo)

        val database = Room.databaseBuilder(
            applicationContext,
            AppDatabase::class.java,
            "Utilizador-db"
        ).build()

        UtilizadorRepository = UtilizadorRepository(database.())



        val btnInserir = findViewById<Button>(R.id.Registo)
        btnInserir.setOnClickListener {
            lifecycleScope.launch {
                inserirUtilizador()
            }
        }

        val buttonToMainActivity: Button = findViewById(R.id.Registo)
        buttonToMainActivity.setOnClickListener {
            startActivity(Intent(this, Eventos::class.java))
        }
    }

    suspend fun inserirUtilizador() {

        val editNome = findViewById<EditText>(R.id.nome)
        val editEmail = findViewById<EditText>(R.id.Email_Textinput)
        val editPassword = findViewById<EditText>(R.id.password_Textinput)
        val editPasswordConfirm = findViewById<EditText>(R.id.password_Textinput)

        val nome = editNome.text.toString()
        val email = editEmail
        val password = editPassword
        val passwordConf = editPasswordConfirm

        val novoUtilizador = Utilizador(nome = nome, email = email , password = password, passwordConfirm = passwordConf )

        UtilizadorRepository.inserirUtilizador(novoUtilizador)

        editNome.text.clear()
        editEmail.text.clear()
        editPassword.text.clear()
        editPasswordConfirm.text.clear()
        editNome.requestFocus()
        atualizarListaUtilizadores()
    }

    override fun onResume() {
        super.onResume()
        atualizarListaUtilizadores()
    }

    private fun atualizarListaUtilizadores() {
        lifecycleScope.launch{
            val listarUtilizador = withContext(Dispatchers.IO)
            {
                UtilizadorRepository.listarUtilizador()
            }
        }
    }

    fun voltar(view: View) {
        finish()
    }
}