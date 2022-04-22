package com.adl.ujiandays18.service


import com.adl.ujiandays18.model.ResponsePostAbsen
import okhttp3.MultipartBody
import okhttp3.RequestBody
import retrofit2.Call
import retrofit2.http.*

interface absen {

    //ambil get
    @Headers("X-Api-Key:36BEE1EAA95D4DC0317F64F0B9B811E2")
    @GET("api/absen/all")
    fun getAllAbsen(): Call<ResponsePostAbsen>

    //post data
    @FormUrlEncoded
    @Headers("X-Api-Key:36BEE1EAA95D4DC0317F64F0B9B811E2")
    @POST("api/absen/add")
    fun addData(@Field("kategori") kategori:String, @Field("dari")dari:String,
                @Field("sampai") sampai:String, @Field("perihal") perihal:String,
                @Field("keterangan") keterangan:String): Call<ResponsePostAbsen>


    @Multipart
    @Headers("X-Api-Key:36BEE1EAA95D4DC0317F64F0B9B811E2")
    @POST("api/absen/add")
    fun addDataAndImage(@Part("username") username: RequestBody, @Part("tanggalmasuk")tanggalmasuk: RequestBody,
                        @Part("tanggalkeluar") tanggalkeluar: RequestBody, @Part("lokasi") lokasi: RequestBody,
                        @Part file: MultipartBody.Part): Call<ResponsePostAbsen>
}