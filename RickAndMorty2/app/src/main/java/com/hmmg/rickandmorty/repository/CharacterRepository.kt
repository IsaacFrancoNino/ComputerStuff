package com.hmmg.rickandmorty.repository

import com.hmmg.rickandmorty.model.CharacterModel
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers

interface CharacterRepository {
    suspend fun fetchCharacters(page: Int): List<CharacterModel>

}

class CharacterRepositoryV1(
    private val dispatcher: CoroutineDispatcher = Dispatchers.IO
): CharacterRepository{

    val charcters = emptyArray<CharacterModel>()

    override suspend fun fetchCharacters(page: Int): List<CharacterModel>{
        TODO("Not yet implemented")
    }
}