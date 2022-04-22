package com.adl.ujiandays18.service

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitConfig {
    fun getInterceptor(): OkHttpClient {
        val logging = HttpLoggingInterceptor()
        logging.level = HttpLoggingInterceptor.Level.BODY
        val okHttpClient = OkHttpClient.Builder()
            .addInterceptor(logging)
            .build()
        return okHttpClient
    }

    fun getRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl("http://192.168.100.9/cicool/")//liat di cmd ipconfig
            .client(getInterceptor())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
   fun getLogin() = getRetrofit().create(login::class.java)
   fun getAbsen() = getRetrofit().create(absen::class.java)




}