package com.example.repoapp.ui.auth

interface AuthListener {
    val loginResponse: Any

    fun onStarted()
    fun onSuccess(loginResponse: Unit)
    fun onFailure(message: String)

}