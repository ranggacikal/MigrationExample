package com.ranggacikal.migrationexample.repository

import com.ranggacikal.migrationexample.model.LoginResponse
import com.ranggacikal.migrationexample.model.RegisterResponse
import com.ranggacikal.migrationexample.model.ResponseDataUser
import com.ranggacikal.migrationexample.network.NetworkConfig
import retrofit2.Call

class UserRepositoryImpl : UserRepository {
    override fun getDataUser(): Call<ResponseDataUser> {
        return NetworkConfig.getApiService().getDataUsers()
    }

    override fun requestRegister(
        username: String?,
        password: String?,
        namaLengkap: String?
    ): Call<RegisterResponse> {
        return NetworkConfig.getApiService().registerUser(username, password, namaLengkap)
    }

    override fun requestLogin(username: String?, password: String?): Call<LoginResponse> {
        return NetworkConfig.getApiService().login(username, password)
    }
}