package com.app.cepconsulta.mapper

import com.app.cepconsulta.data.model.CepResponse
import com.app.cepconsulta.model.CepModel

fun CepResponse.toModel() = CepModel(
    this.cep,
    this.logradouro,
    this.complemento,
    this.bairro,
    this.localidade
)