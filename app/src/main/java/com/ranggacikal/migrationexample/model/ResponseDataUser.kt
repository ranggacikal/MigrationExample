package com.ranggacikal.migrationexample.model

import com.google.gson.annotations.SerializedName

data class ResponseDataUser(

    @field:SerializedName("ResponseDataUser")
    val responseDataUser: List<ResponseDataUser?>? = null

)

data class ResponseDataUsersItem(
    @field:SerializedName("id_user")
    val id_user: String? = null,

    @field:SerializedName("username")
    val username: String? = null,

    @field:SerializedName("password")
    val password: String? = null,

    @field:SerializedName("nama_lengkap")
    val namaLengkap: String? = null,
)
