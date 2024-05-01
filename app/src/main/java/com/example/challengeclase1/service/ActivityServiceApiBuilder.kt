package com.example.challengeclase1.service

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ActivityServiceApiBuilder {

    private val BASE_URL = "https://collectionapi.metmuseum.org/"

    private val retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    fun create(): MuseumService {
        return retrofit.create(MuseumService::class.java)
    }
}