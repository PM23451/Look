package com.example.aprendizagemmobile

import android.content.Context
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity

class Config : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_config)
    }

   val sessionManager = SessionManager(this)
   sessionManager.alterarNome("Novo Nome")

    fun voltar(view: View) {
        finish()
    }

}