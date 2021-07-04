package com.app.cepconsulta.data

import com.google.gson.annotations.SerializedName

data class CepResponse(
    @field:SerializedName("cep") val cep: String
)
