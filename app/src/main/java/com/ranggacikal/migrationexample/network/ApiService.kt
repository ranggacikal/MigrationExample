package com.ranggacikal.migrationexample.network

import com.ranggacikal.migrationexample.model.LoginResponse
import com.ranggacikal.migrationexample.model.RegisterResponse
import com.ranggacikal.migrationexample.model.ResponseDataUser
import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.POST

interface ApiService {
    @GET("getDataUser")
    fun getDataUsers(): Call<ResponseDataUser>

    @FormUrlEncoded
    @POST("register")
    fun registerUser(
        @Field("username") username: String?,
        @Field("password") password: String?,
        @Field("nama_lengkap") namaLengkap: String?
    ): Call<RegisterResponse>

    @FormUrlEncoded
    @POST("login")
    fun login(
        @Field("username") username: String?,
        @Field("password") password: String?
    ): Call<LoginResponse>
}