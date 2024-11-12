package com.cincinnatiai.rickandmortyisaac.ui.characters

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.cincinnatiai.rickandmortyisaac.R
import com.cincinnatiai.rickandmortyisaac.api.CharactersApi
import com.cincinnatiai.rickandmortyisaac.model.CharacterModel
import com.cincinnatiai.rickandmortyisaac.model.Info
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class CharactersViewModel(
    private val api: CharactersApi
): ViewModel() {

    //encapsulate the info
    //emmit what its observing
    private  val _state = MutableLiveData<CharactersUIState>()
    val state: LiveData<CharactersUIState> = _state
    private var currentPage = 0
    private var currentInfo: Info? = null
    private val characters = mutableListOf<CharacterModel>()

    fun fetchCharacters(){
        _state.postValue(CharactersUIState.Loading)
        viewModelScope.launch(Dispatchers.IO){
            try{
                val response = api.fetchCharacters(currentPage)
                currentInfo = response.info
                characters.addAll(response.results)
                _state.postValue(CharactersUIState.CharactersLoaded(characters))
                currentPage += 1
            }catch(e: Throwable){
                _state.postValue(CharactersUIState.Error(R.string.generic_error_message))
            }
        }

    }


}

//Defining the states
sealed class CharactersUIState{
    object Loading: CharactersUIState()
    data class CharactersLoaded(val characters: List<CharacterModel>): CharactersUIState()
    data class Error (val errorMesage: Int): CharactersUIState()
}