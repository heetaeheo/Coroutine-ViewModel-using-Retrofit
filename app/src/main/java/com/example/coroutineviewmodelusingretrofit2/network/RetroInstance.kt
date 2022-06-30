package com.example.coroutineviewmodelusingretrofit2.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetroInstance  {

    companion object{
        val baseUrl = "https://avatars1.githubusercontent.com/"

        fun getRetroInstace() : Retrofit{
            return Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }
    }
}