package com.app.cepconsulta.model

sealed class Result<out L, out R>(){
    data class Success<out L>(val value: L): Result<L, Nothing>()
    data class Error<out R>(val value: R): Result<Nothing, R>()
}
