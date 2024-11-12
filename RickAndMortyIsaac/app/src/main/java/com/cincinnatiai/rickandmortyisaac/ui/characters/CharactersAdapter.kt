package com.cincinnatiai.rickandmortyisaac.ui.characters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.cincinnatiai.rickandmortyisaac.databinding.ItemCharacterBinding
import com.cincinnatiai.rickandmortyisaac.model.CharacterModel

class CharactersAdapter: RecyclerView.Adapter<CharacterViewHolder>() {
    private val items = mutableListOf<CharacterModel>()
    fun setItems(models: List<CharacterModel>){
        items.clear()
        items.addAll(models)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CharacterViewHolder {
        val binding = ItemCharacterBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CharacterViewHolder(binding)
    }

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: CharacterViewHolder, position: Int) {
        holder.bindModelToView(items[position])
    }
}