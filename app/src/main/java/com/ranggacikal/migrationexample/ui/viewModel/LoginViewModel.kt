package com.ranggacikal.migrationexample.ui.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.ranggacikal.migrationexample.model.LoginResponse
import com.ranggacikal.migrationexample.repository.UserRepositoryImpl
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LoginViewModel: ViewModel() {

    val repository = UserRepositoryImpl()

    val loginObserver: MutableLiveData<LoginResponse> = MutableLiveData()

    fun requestLogin(username: String, password: String): LiveData<LoginResponse> {
        repository.requestLogin(username, password).enqueue(object : Callback<LoginResponse> {
            override fun onResponse(call: Call<LoginResponse>, response: Response<LoginResponse>) {
                if (response.isSuccessful) loginObserver.value = response.body()
                else loginObserver.value = LoginResponse(sukses = false)
            }

            override fun onFailure(call: Call<LoginResponse>, t: Throwable) {
                t.printStackTrace()
            }

        })
        return loginObserver
    }

}