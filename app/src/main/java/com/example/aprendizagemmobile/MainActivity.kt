package com.example.aprendizagemmobile

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import androidx.room.Room
import com.example.aprendizagemmobile.dao.AppDatabase
import com.example.aprendizagemmobile.dao.UtilizadorRepository
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    private lateinit var database: AppDatabase
    private lateinit var databaseUtilizador: AppDatabase
    private lateinit var UtilizadorRepository: UtilizadorRepository
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val sessionManager = SessionManager(this)
        val nome = sessionManager.obterNomeUtilizador()
        //val email = sessionManager.obterEmailUtilizador()
        if(nome != null) {
            val intent = Intent(this, Home::class.java)
            startActivity(intent)
        }

        database = Room.databaseBuilder(
            applicationContext,
            AppDatabase::class.java,
            "eventos-db"
        ).build()

        databaseUtilizador = Room.databaseBuilder(
            applicationContext,
            AppDatabase::class.java,
            "Utilizador-db"
        ).build()

        UtilizadorRepository = UtilizadorRepository(databaseUtilizador.utilizadorDao())
        //Event listner para o botão de login
        val btnLogin = findViewById<Button>(R.id.Login)
        btnLogin.setOnClickListener {
            lifecycleScope.launch {
                login()
            }
        }
    }

    fun navegarParaRegisto(view: View) {
        val intent = Intent(this, Registo::class.java)
        startActivity(intent)
    }

    suspend fun login() {

        val users = UtilizadorRepository.listarUtilizador()
        Log.d("MainActivity", "Users: $users")
        val editEmail = findViewById<EditText>(R.id.Email_Textinput)
        val editPassword = findViewById<EditText>(R.id.Password_Textinput)

        val email = editEmail.text.toString()
        val password = editPassword.text.toString()

        val res = UtilizadorRepository.login(email, password)
        if (res != null) {
            val sessionManager = SessionManager(this)
            sessionManager.guardarInformacoesUtilizador(res.nome, res.email)

            val intent = Intent(this, Home::class.java)
            startActivity(intent)
        }
        else {
            editEmail.error = "Credenciais inválidas"
            editPassword.error = "Credenciais inválidas"
        }
    }

    /* CoroutineScope(Dispatchers.Main).launch {
            val loginBemSucedido = UtilizadorRepository.realizarLogin(email, senha)

            if (loginBemSucedido) {
                // Executar ação de sucesso, por exemplo, navegar para a próxima tela
                // ou exibir uma mensagem de login bem-sucedido.
                Toast.makeText(this@MainActivity, "Login bem-sucedido!", Toast.LENGTH_SHORT).show()
            } else {
                // Executar ação para tratar login mal-sucedido, por exemplo, exibir uma mensagem de erro.
                Toast.makeText(this@MainActivity, "Credenciais inválidas", Toast.LENGTH_SHORT).show()
            }
        }*/
}