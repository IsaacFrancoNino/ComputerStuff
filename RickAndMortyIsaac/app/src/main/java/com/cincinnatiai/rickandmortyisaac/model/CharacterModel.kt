package com.cincinnatiai.rickandmortyisaac.model

data class CharacterModel(
    val id: Long,
    val name: String,
    val status: String,
    val image: String? = null
)