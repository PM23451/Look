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

        // Colocar a lista de cidades no Spinner
        val cidadesService = RetrofitClient.cidadesService
        val call = cidadesService.getCidades()

        call.enqueue(object : Callback<List<String>> {
            override fun onResponse(call: Call<List<String>>, response: Response<List<String>>) {
                val cidades = response.body() ?: emptyList()
                val adapter = CidadesAdapter(this@Home, android.R.layout.simple_spinner_item, cidades)
                spinnerCidades.adapter = adapter
            }

            override fun onFailure(call: Call<List<String>>, t: Throwable) {
                t.printStackTrace()
            }
        })
    }
}
