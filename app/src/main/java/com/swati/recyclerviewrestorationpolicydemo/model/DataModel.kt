package com.swati.recyclerviewrestorationpolicydemo.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class DataModel(
    @Expose
    @SerializedName("title")
    val title: String,
    @Expose
    @SerializedName("thumbnailUrl")
    val thumbnailUrl: String
)