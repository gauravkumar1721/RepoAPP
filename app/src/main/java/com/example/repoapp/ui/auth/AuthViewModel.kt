package com.example.repoapp.ui.auth

import android.view.View
import androidx.lifecycle.ViewModel
import com.example.repoapp.data.repository.UserRepository

class AuthViewModel: ViewModel() {
    var email: String? = null
    var password: String? = null

    var authListener: AuthListener? = null
    fun onLoginButtonClick(view: View){
        authListener?.onStarted()
      if(email.isNullOrEmpty() || password.isNullorEmpty()){
        authListener?.onFailure("invaild email or password")

      }
        val loginResponse = UserRepository().userLogin(email!!, password!!)
        val onSuccess = authListener?.onSuccess(loginResponse)
    }

    }

private fun String?.isNullorEmpty(): Boolean {

    return true
}
