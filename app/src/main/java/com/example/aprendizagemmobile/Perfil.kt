package com.example.aprendizagemmobile
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class Perfil : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registo)
    }

    fun voltar(view: View) {
        finish()
    }
}