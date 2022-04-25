package com.adl.ujiandays18.service
//STEP0.4

import com.adl.ujiandays18.model.ResponseAbsen
import com.adl.ujiandays18.model.ResponsePostData
import okhttp3.MultipartBody
import okhttp3.RequestBody
import retrofit2.Call
import retrofit2.http.*

interface absen {
//get data
    @Headers("X-Api-Key:6D83551EAC167A26DC10BB7609EA9AEF")
    @GET("api/absen/all")
    fun getId (@Query("field")  field:String, @Query("filter") filter:String ) : Call<ResponseAbsen>

    @Headers("X-Api-Key:6D83551EAC167A26DC10BB7609EA9AEF")
    @GET("api/absen/all")
    fun getAllAbsen () : Call<ResponseAbsen>

//post data
    @Multipart
    @Headers("X-Api-Key:36BEE1EAA95D4DC0317F64F0B9B811E2")
    @POST("api/absen/add")
    fun addDataAndImage(@Part("username") username: RequestBody, @Part("tanggalmasuk")tanggalmasuk: RequestBody,
                        @Part("tanggalkeluar") tanggalkeluar: RequestBody, @Part("gps") gps: RequestBody,
                        @Part file: MultipartBody.Part): Call<ResponsePostData>
//post update
    @FormUrlEncoded
    @Headers("X-Api-Key:6D83551EAC167A26DC10BB7609EA9AEF")
    @POST("api/absen/update")
    fun updateCheckout(@Field("id") id:String,@Field("username") username:String,
                       @Field("tanggalkeluar") tanggalkeluar:String):Call<ResponsePostData>
}