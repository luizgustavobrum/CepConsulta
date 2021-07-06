package com.app.cepconsulta.ui

import com.app.cepconsulta.model.CepModel

sealed class UiCepState {
    object Inital : UiCepState()
    object Loading : UiCepState()
    data class Success(val success: CepModel) : UiCepState()
    data class Error(val error: String) : UiCepState()
}
