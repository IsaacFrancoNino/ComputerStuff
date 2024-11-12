package com.hmmg.rickandmorty.model


interface CharacterModel{
    val id : Long
    val name: String
    val  description : String
    val image: String
}

data class Character (
    override val id : Long,
    override val name: String,
    override val  description : String,
    override val image: String

) :CharacterModel