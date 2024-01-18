package com.example.aprendizagemmobile
import android.content.Context
import android.content.SharedPreferences

class SessionManager(context: Context) {
    private val sharedPreferences: SharedPreferences = context.getSharedPreferences("SessionPrefs", Context.MODE_PRIVATE)
    private val editor: SharedPreferences.Editor = sharedPreferences.edit()

    companion object {
        const val KEY_NAME = "user_name"
        const val KEY_EMAIL = "user_email"
    }

    fun guardarInformacoesUtilizador(nome: String, email: String) {
        editor.putString(KEY_NAME, nome)
        editor.putString(KEY_EMAIL, email)
        editor.apply()
    }

    fun obterNomeUtilizador(): String? {
        return sharedPreferences.getString(KEY_NAME, null)
    }

    fun obterEmailUtilizador(): String? {
        return sharedPreferences.getString(KEY_EMAIL, null)
    }

    fun definirNomeUtilizador(novoNome: String){
        val sharedPreferences = context.getSharedPreferences("Minhas Preferencias", Context.MODE_PRIVATE);
        val editor = sharedPreferences.edit()
        editor.putString("NOME_USUARIO", novoNome)
        editor.apply()
    }

    fun definirEmailUtilizador(novoEmail: String){
        val sharedPreferences = context.getSharedPreferences("Minhas Preferencias", Context.MODE_PRIVATE);
        val editor = sharedPreferences.edit()
        editor.putString("EMAIL_USUARIO", novoEmail)
        editor.apply()
    }


    fun limparSessao() {
        editor.remove(KEY_NAME)
        editor.remove(KEY_EMAIL)
        editor.apply()
    }
}
