package com.ranggacikal.migrationexample.model

import com.google.gson.annotations.SerializedName

data class LoginResponse(

	@field:SerializedName("pesan")
	val pesan: String? = null,

	@field:SerializedName("sukses")
	val sukses: Boolean? = null,

	@field:SerializedName("status")
	val status: Int? = null
)
