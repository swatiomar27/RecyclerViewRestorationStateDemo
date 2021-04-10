package com.swati.recyclerviewrestorationpolicydemo.api

import com.swati.recyclerviewrestorationpolicydemo.model.DataModel
import retrofit2.Call
import retrofit2.http.GET

interface ApiInterface {

    @GET("photos")
    fun getPhotos(): Call<List<DataModel>>
}