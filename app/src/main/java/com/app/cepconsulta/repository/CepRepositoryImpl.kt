package com.app.cepconsulta.repository

import com.app.cepconsulta.data.CepService.cepServiceInterfaceImpl
import com.app.cepconsulta.mapper.toModel
import com.app.cepconsulta.model.CepModel
import com.app.cepconsulta.model.Result
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext
import java.lang.Exception

class CepRepositoryImpl : CepRepository {
    override suspend fun getCep(
        cep: String,
        dispatcher: CoroutineDispatcher
    ): Result<CepModel, String> = withContext(dispatcher) {
        try {
            val response = cepServiceInterfaceImpl.cepInformation(cep)
            if (response.isSuccessful && response.body() != null) {
                Result.Success(value = response.body()!!.toModel())
            } else {
                Result.Error(value = "Response is not successful or body is null")
            }

        } catch (e: Exception) {
            Result.Error(value = e.toString())
        }
    }
}