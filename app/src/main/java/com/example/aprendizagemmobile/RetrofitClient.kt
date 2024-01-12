package com.example.aprendizagemmobile

import com.example.aprendizagemmobile.api.CidadesService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClient {
    const val BASE_URL = "https://json.geoapi.pt/municipio/"

    val cidadesService: CidadesService by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(CidadesService::class.java)
    }
}
