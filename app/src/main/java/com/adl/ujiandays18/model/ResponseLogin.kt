package com.adl.ujiandays18.model
//STEP0.1
import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class ResponseLogin(

	@field:SerializedName("total")
	val total: Int? = null,

	@field:SerializedName("data")
	val data: DataLogin? = null,

	@field:SerializedName("message")
	val message: String? = null,

	@field:SerializedName("status")
	val status: Boolean? = null
) : Parcelable

@Parcelize
data class DataLogin(

	@field:SerializedName("ujianlogin")
	val ujianlogin: List<UjianloginItem?>? = null
) : Parcelable

@Parcelize
data class UjianloginItem(

	@field:SerializedName("password")
	val password: String? = null,

	@field:SerializedName("id")
	val id: String? = null,

	@field:SerializedName("username")
	val username: String? = null
) : Parcelable
