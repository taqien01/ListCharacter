package com.aplikasi.listcharacter.model

import com.google.gson.annotations.SerializedName
import java.io.Serializable

class ListCharacter : Serializable {
    @SerializedName("info")
    val info: Info? = null

    @SerializedName("results")
    val results: List<Results>? = null
}

class Results : Serializable{
    @SerializedName("id")
    val id: Int? = 0

    @SerializedName("name")
    val name: String? = null

    @SerializedName("status")
    val status: String? = null

    @SerializedName("species")
    val species: String? = null

    @SerializedName("type")
    val next: String? = null

    @SerializedName("gender")
    val gender: String? = null

    @SerializedName("origin")
    val origin: Origin? = null

    @SerializedName("location")
    val location: Location? = null

    @SerializedName("image")
    val image: String? = null

    @SerializedName("episode")
    val episode: List<String>? = null

    @SerializedName("url")
    val url: String? = null

    @SerializedName("created")
    val created: String? = null
}

class Origin : Serializable{
    @SerializedName("name")
    val name: String? = null

    @SerializedName("url")
    val url: String? = null
}

class Location : Serializable{
    @SerializedName("name")
    val name: String? = null

    @SerializedName("url")
    val url: String? = null
}

class Info : Serializable {
    @SerializedName("count")
    val count: Int? = 0

    @SerializedName("pages")
    val pages: Int? = 0

    @SerializedName("next")
    val next: String? = null

    @SerializedName("prev")
    val prev: String? = null
}