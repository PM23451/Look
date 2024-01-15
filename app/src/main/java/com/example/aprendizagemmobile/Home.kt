package com.example.aprendizagemmobile
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Spinner
import androidx.appcompat.app.AppCompatActivity
import com.example.aprendizagemmobile.adapter.CidadesAdapter
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class Home : AppCompatActivity() {

    private lateinit var spinnerCidades: Spinner

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        // Referência ao Spinner no layout
        spinnerCidades = findViewById(R.id.spinner)

        // Chamada à API para obter a lista de cidades
        val call = RetrofitClient.cidadesService.getCidades()
        call.enqueue(object : Callback<List<String>> {
            override fun onResponse(call: Call<List<String>>, response: Response<List<String>>) {
                if (response.isSuccessful) {
                    // Configurar o adaptador com a lista de cidades
                    val cidadesAdapter = CidadesAdapter(this@Home, android.R.layout.simple_spinner_item, response.body()!!)
                    cidadesAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)

                    // Associar o adaptador ao Spinner
                    spinnerCidades.adapter = cidadesAdapter
                } else {
                    // Tratar erros de resposta
                }
            }

            override fun onFailure(call: Call<List<String>>, t: Throwable) {
                // Tratar falhas na comunicação com a API
            }
        })
    }
}
