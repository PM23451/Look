package com.example.aprendizagemmobile

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity

class Config : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_config)
    }

    fun alterarNome (view : View){
        val sessionManager = SessionManager(this)
        val nome = sessionManager.obterNomeUtilizador()
    }
    fun voltar(view: View) {
        finish()
    }

}