package com.example.aprendizagemmobile
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity

class Eventos : AppCompatActivity()
{
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.item_evento)
    }

    fun voltar(view: View) {
        finish()
    }
}