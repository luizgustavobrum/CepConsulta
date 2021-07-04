package com.app.cepconsulta.data

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object CepService {

    const val BASE_URL = "https://viacep.com.br/ws/"

    fun createCepServiceRetrofit(): Retrofit = Retrofit
        .Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val cepServiceInterfaceImpl: CepServiceInterface = createCepServiceRetrofit().create(CepServiceInterface::class.java)

}