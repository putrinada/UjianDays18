package com.adl.ujiandays18.service

import com.adl.ujiandays18.model.ResponsePostLogin
import retrofit2.Call
import retrofit2.http.*

interface login {
    //get
    @Headers("X-Api-Key:36BEE1EAA95D4DC0317F64F0B9B811E2")
    @GET("api/ujianlogin/all")
    fun getAllLogin(): Call<ResponsePostLogin>
    //post
    @FormUrlEncoded
    @Headers("X-Api-Key:36BEE1EAA95D4DC0317F64F0B9B811E2")
    @POST("api/ujianlogin/add")

    fun addData(@Field("username") username:String, @Field("password") password : String)
            : Call<ResponsePostLogin>
}