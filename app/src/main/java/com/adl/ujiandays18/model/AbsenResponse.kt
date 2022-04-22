package com.adl.ujiandays18.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class AbsenResponse(

	@field:SerializedName("total")
	val total: Int? = null,

	@field:SerializedName("data")
	val data: Data? = null,

	@field:SerializedName("message")
	val message: String? = null,

	@field:SerializedName("status")
	val status: Boolean? = null
) : Parcelable

@Parcelize
data class AbsenItem(

	@field:SerializedName("tanggalkeluar")
	val tanggalkeluar: String? = null,

	@field:SerializedName("datafoto")
	val datafoto: String? = null,

	@field:SerializedName("tanggalmasuk")
	val tanggalmasuk: String? = null,

	@field:SerializedName("lokasi")
	val lokasi: String? = null,

	@field:SerializedName("id")
	val id: String? = null,

	@field:SerializedName("username")
	val username: String? = null
) : Parcelable

@Parcelize
data class Data(

	@field:SerializedName("absen")
	val absen: List<AbsenItem?>? = null
) : Parcelable
