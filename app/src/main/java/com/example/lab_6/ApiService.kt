package com.example.lab_6

import retrofit2.http.GET
import retrofit2.http.Query

interface RetrofitRecepts {
    @GET("lookup.php")
    suspend fun getEvents(@Query("i") id: String): MealList
}