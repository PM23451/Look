package com.example.aprendizagemmobile
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class Perfil : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registo)
    }

    val sessionManager = SessionManager(this)
    val nome = sessionManager.obterNomeUtilizador()
    val email = sessionManager.obterEmailUtilizador()

    fun voltar(view: View) {
        finish()
    }
}