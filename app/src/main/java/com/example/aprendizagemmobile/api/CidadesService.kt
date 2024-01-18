package com.example.aprendizagemmobile.api

import retrofit2.Call
import retrofit2.http.GET

interface CidadesService {
    @GET("distritos")
    fun getCidades(): Call<List<String>>
}
