package com.app.cepconsulta.data

import com.google.gson.annotations.SerializedName

data class CepResponse(
    @field:SerializedName("cep") val cep: String,
    @field:SerializedName("logradouro"),
    @field:SerializedName("complemento"),
    @field:SerializedName("bairro"),
    @field:SerializedName(""),
)
