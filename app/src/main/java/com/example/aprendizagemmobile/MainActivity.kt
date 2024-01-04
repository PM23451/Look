package com.example.aprendizagemmobile

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun navegarParaRegisto(view: View) {
        val intent = Intent(this, Registo::class.java)
        startActivity(intent)
    }

    fun login(view: View) {
        val intent = Intent(this, Home::class.java)
        startActivity(intent)
    }


}