package com.example.repoapp.data.repository

import androidx.lifecycle.MutableLiveData
import com.example.repoapp.data.network.MyApi
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class UserRepository {
    fun userLogin(email: String, password: String) {
        val loginResponse = MutableLiveData<String>()

        MyApi().userLogin(email, password)
            .enqueue(object : Callback<ResponseBody> {
                override fun onResponse(
                    call: Call<ResponseBody>,
                    response: Response<ResponseBody>
                ) {
                    if(response.isSuccessful){
                        loginResponse.value = response.body()?.string()
                    }else{
                        loginResponse.value = response.errorBody()?.string()
                    }
                }

                override fun onFailure(call: Call<ResponseBody>, t: Throwable) {
                    loginResponse.value = t.message
                }

            })

    }
}

private fun Unit.enqueue(callback: Callback<ResponseBody>) {


}
