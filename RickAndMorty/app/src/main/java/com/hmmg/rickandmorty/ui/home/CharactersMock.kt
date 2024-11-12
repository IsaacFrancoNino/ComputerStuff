package com.hmmg.rickandmorty.ui.home

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.hmmg.rickandmorty.ui.model.CharacterInfo


object CharactersMock {
    val characterInfoLists = listOf( CharacterInfo(id = 1, name = "rick", description = "no desc", image = "ss" ),
                                CharacterInfo(id = 2, name = "morty", description = "no desc", image = "ss" ))
}
@Composable
fun CharacterListItem(characterInfo: CharacterInfo){
    Row {
        Column(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth()
                .align(Alignment.CenterVertically)
                .clickable {  }
        ) {

            Text( text = characterInfo.name)
            Text(text = characterInfo.description)
        }
    }
}