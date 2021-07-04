package com.app.cepconsulta.data.model

import com.google.gson.annotations.SerializedName

data class CepResponse(
    @field:SerializedName("cep") val cep: String,
    @field:SerializedName("logradouro") val logradouro: String,
    @field:SerializedName("complemento") val complemento: String,
    @field:SerializedName("bairro") val bairro: String,
    @field:SerializedName("localidade") val localidade: String,
)
