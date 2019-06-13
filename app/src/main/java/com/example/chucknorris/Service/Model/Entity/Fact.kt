package com.example.chucknorris.Service.Model.Entity

import com.google.gson.annotations.SerializedName

data class Fact (
    @SerializedName("id") val id: String,
    @SerializedName("icon_url") val img: String,
    @SerializedName("value") val quote: String
)