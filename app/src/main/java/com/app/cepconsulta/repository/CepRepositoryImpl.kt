package com.app.cepconsulta.repository

import android.util.Log
import com.app.cepconsulta.data.CepService.cepServiceInterfaceImpl
import com.app.cepconsulta.mapper.toModel
import com.app.cepconsulta.model.CepModel
import com.app.cepconsulta.model.Result
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext
import retrofit2.HttpException
import java.lang.Exception

class CepRepositoryImpl : CepRepository {

    companion object {
        private val TAG = CepRepositoryImpl::class.java.name
    }

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

        } catch (e: HttpException) {
            Log.e(TAG, e.toString())
            Result.Error(value = ">>>HttpException${e.toString()}")
        } catch (e: Exception) {
            Log.e(TAG, e.toString())
            Result.Error(value = e.toString())
        }
    }
}