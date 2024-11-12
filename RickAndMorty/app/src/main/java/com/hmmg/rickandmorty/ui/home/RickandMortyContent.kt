package com.hmmg.rickandmorty.ui.home

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.lazy.items

@Composable
 fun RickandMortyContent(){
    val characters = remember { CharactersMock.characterInfoLists }
    LazyColumn (
        contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp)

    ){
        items(
            items = characters,
            itemContent = {
                CharacterListItem(characterInfo = it)
            })
    }
}