package com.example.challengeclase1.service

import com.example.challengeclase1.entities.MuseumObject
import com.example.challengeclase1.entities.MuseumObjects
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface MuseumService {

    @GET("public/collection/v1/search?hasImages=true")
    fun getObjects(@Query("q") q: String): Call<MuseumObjects>

    @GET("public/collection/v1/objects/{objectId}")
    fun getObject(@Path("objectId") objectId: Int): Call<MuseumObject>

}