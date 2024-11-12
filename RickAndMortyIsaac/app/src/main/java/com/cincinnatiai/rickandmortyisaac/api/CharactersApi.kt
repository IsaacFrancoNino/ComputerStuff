package com.cincinnatiai.rickandmortyisaac.api

import com.cincinnatiai.rickandmortyisaac.model.CharacterResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface CharactersApi {

    @GET("character")
    suspend fun fetchCharacters(@Query("page") page: Int? = null): CharacterResponse

}