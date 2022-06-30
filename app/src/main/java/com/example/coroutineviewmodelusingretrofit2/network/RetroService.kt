package com.example.coroutineviewmodelusingretrofit2.network

import okhttp3.ResponseBody
import retrofit2.http.GET
import retrofit2.http.Query

interface RetroService {


    @GET("33503405?v=4")
    suspend fun getImageFromUrl(@Query("v")query: String): ResponseBody

}