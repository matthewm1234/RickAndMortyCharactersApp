package com.example.rickandmortycharacters.api

class Repository(private  val apiService:ApiService) {
    suspend fun getCharacters(character: String) = apiService.getCharacters(character)
}