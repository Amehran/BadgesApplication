package com.example.achievements.data_source.network.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class CustomResponseItem(
        @SerializedName("image")
        @Expose
        val image: Int,
        @SerializedName("imageUrl")
        @Expose
        val imageUrl: String,
        @SerializedName("tile")
        @Expose
        val title: String,
        @SerializedName("description")
        @Expose
        val description: String,
        @SerializedName("header")
        @Expose
        val header: String
)
{
        override fun toString(): String {
                return "Achievement(image='$image', imageUrl='$imageUrl',title='$title', description='$description',header='$header')"
        }
}