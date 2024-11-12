package com.hmmg.rickandmorty.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.hmmg.rickandmorty.databinding.ItemCharacterBinding
import com.hmmg.rickandmorty.model.CharacterModel

class CharacterAdapter : RecyclerView.Adapter<CharacterViewHolder>() {

    private val items = mutableListOf<CharacterModel>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CharacterViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val characterViewHolder = CharacterViewHolder(ItemCharacterBinding.inflate(inflater, parent, false))
        return characterViewHolder
    }

    override fun getItemCount() = items.size

    override fun onBindViewHolder(holder: CharacterViewHolder, position: Int) {
        holder.bindModelToView(items[position])
    }
}