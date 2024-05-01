package com.example.challengeclase1.service

import android.util.Log
import android.view.View
import com.example.challengeclase1.entities.MuseumObject
import com.example.challengeclase1.entities.MuseumObjects
import com.google.android.material.snackbar.Snackbar
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MuseumServiceImpl{


    companion object {
        val service: MuseumService = ActivityServiceApiBuilder.create()
        val museumItems: MutableList<MuseumObject> = ArrayList()

        fun getItems(): MutableList<MuseumObject> {
            service.getObjects("Van Gogh").enqueue(object : Callback<MuseumObjects> {
                override fun onResponse(
                    call: Call<MuseumObjects>,
                    response: Response<MuseumObjects>
                ) {

                    if (response.isSuccessful) {
                        Log.d("RETROFIT-RESPONSE", response.body().toString())
                        val response = response.body()
                        if (response!!.total > 0) {
                            for(i in 0..30){
                                getItem(response.objectIDs[i])
                            }
                        }
                    }

                }

                override fun onFailure(call: Call<MuseumObjects>, t: Throwable) {
                    Log.e("Retrofit-error", t.stackTraceToString())
                }
            })

            return museumItems;
        }

        fun getItem(id: Int) {
            service.getObject(id).enqueue(object : Callback<MuseumObject> {
                override fun onResponse(
                    call: Call<MuseumObject>,
                    response: Response<MuseumObject>
                ) {

                    if (response.isSuccessful) {
                        Log.d("RETROFIT-ID", response.body().toString())
                        val response = response.body()
                        museumItems.add(response!!)
                    }

                }

                override fun onFailure(call: Call<MuseumObject>, t: Throwable) {
                    Log.e("Retrofit-error", t.stackTraceToString())
                }
            })
        }
    }
}