package com.app.cepconsulta.data

import com.app.cepconsulta.data.model.CepResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface CepServiceInterface {
    @GET(value = "{cep}/json")
    suspend fun cepInformation(@Path("cep") cep: String) : Response<CepResponse>
}