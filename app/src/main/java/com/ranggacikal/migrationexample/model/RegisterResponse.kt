package com.ranggacikal.migrationexample.model

data class RegisterResponse(
    val sukses: Boolean? = null,
    val status: Int? = null,
    val data: DataRegister? = null
) {
    data class DataRegister(
        val username: String? = null,
        val password: String? = null,
        val namaLengkap: String? = null
    )
}
