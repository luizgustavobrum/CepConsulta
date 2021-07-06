package com.app.cepconsulta.repository

import com.app.cepconsulta.model.CepModel
import com.app.cepconsulta.model.Result
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers

interface CepRepository {
    suspend fun getCep(
        cep: String,
        dispatcher: CoroutineDispatcher = Dispatchers.IO
    ): Result<CepModel, String>
}