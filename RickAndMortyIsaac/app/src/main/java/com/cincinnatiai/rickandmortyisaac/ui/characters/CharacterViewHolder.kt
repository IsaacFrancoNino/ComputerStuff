package com.cincinnatiai.rickandmortyisaac.ui.characters

import androidx.recyclerview.widget.RecyclerView
import com.cincinnatiai.rickandmortyisaac.databinding.ItemCharacterBinding
import com.cincinnatiai.rickandmortyisaac.model.CharacterModel

class CharacterViewHolder (val binding: ItemCharacterBinding): RecyclerView.ViewHolder(binding.root) {

    fun bindModelToView(model: CharacterModel){
        binding.title.text = model.name
    }

}