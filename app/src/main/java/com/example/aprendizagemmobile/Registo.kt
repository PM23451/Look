package com.example.aprendizagemmobile

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button

class Registo : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registo)

        val buttonToMainActivity: Button = findViewById(R.id.Registo)
        buttonToMainActivity.setOnClickListener {
            startActivity(Intent(this, Eventos::class.java))
        }


    }

    fun voltar(view: View) {
        finish()
    }
}