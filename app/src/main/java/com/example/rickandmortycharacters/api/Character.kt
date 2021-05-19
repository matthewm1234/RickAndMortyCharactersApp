package com.example.rickandmortycharacters.api

import com.squareup.moshi.Json

data class Character(
    @Json(name = "name")
    val characterName : String,
    @Json(name = "status")
    val characterStatus : String,
    @Json(name = "species")
    val characterSpecie: String,
    @Json(name = "image")
    val characterImage: String
)
