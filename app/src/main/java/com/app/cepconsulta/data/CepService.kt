package com.app.cepconsulta.data

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

object CepService {

    const val BASE_URL = "https://viacep.com.br/ws/"
    const val TIME_OUT: Long = 30

    fun createOkHttpClient() = OkHttpClient.Builder()
        .readTimeout(TIME_OUT, TimeUnit.SECONDS)
        .connectTimeout(TIME_OUT, TimeUnit.SECONDS)
        .build()

    fun createCepServiceRetrofit(): Retrofit = Retrofit
        .Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .client(createOkHttpClient())
        .build()

    val cepServiceInterfaceImpl: CepServiceInterface =
        createCepServiceRetrofit().create(CepServiceInterface::class.java)

}