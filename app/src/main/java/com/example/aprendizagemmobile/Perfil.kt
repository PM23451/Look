package com.example.aprendizagemmobile
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView

class Perfil : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_perfil)

        val btnFechar = findViewById<Button>(R.id.logoutButton)
        btnFechar.setOnClickListener {
            val sessionManager = SessionManager(this)
            sessionManager.limparSessao()
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        val sessionManager = SessionManager(this)
        val nome = sessionManager.obterNomeUtilizador()
        val email = sessionManager.obterEmailUtilizador()

        val nomeText = findViewById<TextView>(R.id.textView12)
        val emailText = findViewById<TextView>(R.id.textView9)

        nomeText.text = nome
        emailText.text = email

    }

    fun voltar(view: View) {
        finish()
    }
}