package com.app.cepconsulta.model

data class CepModel(
    val cep: String,
    val logradouro: String,
    val complemento: String,
    val bairro: String,
    val localidade: String,
)
