package com.ranggacikal.migrationexample.repository

import com.ranggacikal.migrationexample.model.LoginResponse
import com.ranggacikal.migrationexample.model.RegisterResponse
import com.ranggacikal.migrationexample.model.ResponseDataUser
import retrofit2.Call

interface UserRepository {
    fun getDataUser(): Call<ResponseDataUser>
    fun requestRegister(
        username: String?,
        password: String?,
        namaLengkap: String?
    ): Call<RegisterResponse>
    fun requestLogin(
        username: String?,
        password: String?
    ): Call<LoginResponse>
}