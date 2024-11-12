package com.hmmg.rickandmorty.home

import androidx.recyclerview.widget.RecyclerView
import com.hmmg.rickandmorty.databinding.ItemCharacterBinding
import com.hmmg.rickandmorty.model.CharacterModel

class CharacterViewHolder(
    private val view: ItemCharacterBinding
): RecyclerView.ViewHolder(view.root){

    fun bindModelToView(character: CharacterModel){
        view.title.text = character.name
    }
}