package com.app.cepconsulta.data

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object CepService {
    fun createCepServiceRetrofit(): Retrofit = Retrofit
        .Builder()
        .baseUrl("https://viacep.com.br/ws/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val cepServiceInterfaceImpl = createCepServiceRetrofit().create(CepServiceInterface::class.java)

}