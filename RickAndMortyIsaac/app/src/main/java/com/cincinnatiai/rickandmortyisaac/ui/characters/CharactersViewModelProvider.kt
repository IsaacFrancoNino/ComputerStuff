package com.cincinnatiai.rickandmortyisaac.ui.characters

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.cincinnatiai.rickandmortyisaac.di.DIModule
import com.cincinnatiai.rickandmortyisaac.model.CharacterModel

class CharactersViewModelProvider: ViewModelProvider.Factory {
    //ctrl + o

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(CharactersViewModel::class.java)){
            return CharactersViewModel(DIModule.charactersApi)as T
        }
        throw IllegalArgumentException("ModelClass must be assignable from CharactersViewModel")
    }
}