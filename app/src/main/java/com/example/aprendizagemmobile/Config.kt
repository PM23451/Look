package com.example.aprendizagemmobile

import android.content.Context
import android.content.Intent
import android.content.res.Configuration
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Switch
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.launch

class Config : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_config)

        val configuration = resources.configuration


        val btnLogin = findViewById<Button>(R.id.notifications)
        btnLogin.setOnClickListener {
            //Ir para perfil
            val intent = Intent(this, Perfil::class.java)
            startActivity(intent)
        }

        val modoEscuro = findViewById<Switch>(R.id.switch1)
        modoEscuro.setOnClickListener {
            val currentNightMode = configuration.uiMode and Configuration.UI_MODE_NIGHT_MASK

            //Definir o modo escuro sem o session manager
            if (currentNightMode == Configuration.UI_MODE_NIGHT_NO) {
                // Night mode is not active, we're in day time
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
            } else {
                // Night mode is active, we're at night!
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
            }


        }
    }

    /*val sessionManager = SessionManager(this)
    val nome = sessionManager.obterNomeUtilizador()*/

    fun voltar(view: View) {
        finish()
    }

}