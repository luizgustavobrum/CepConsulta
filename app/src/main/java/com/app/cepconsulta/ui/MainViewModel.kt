package com.app.cepconsulta.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.app.cepconsulta.model.Result
import com.app.cepconsulta.repository.CepRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class MainViewModel(
    private val repository: CepRepository
) : ViewModel() {

    private val _uiCepState = MutableStateFlow<UiCepState>(UiCepState.Inital)
    val uiCepState: StateFlow<UiCepState> get() = _uiCepState

    fun getCepInformation(cep: String) {
        _uiCepState.value = UiCepState.Loading
        if (cep.length < 8) {
            _uiCepState.value = UiCepState.Error(error = "O número é menor de 8")
        } else {
            viewModelScope.launch {
                val response = repository.getCep(cep)
                when (response) {
                    is Result.Success -> {
                        _uiCepState.value = UiCepState.Success(success = response.value)
                    }
                    is Result.Error -> {
                        _uiCepState.value = UiCepState.Error(error = response.value)
                    }
                }
            }
        }
    }
}