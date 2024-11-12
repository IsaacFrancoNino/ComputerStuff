package com.hmmg.rickandmorty.ui.model

import android.os.Parcelable
import androidx.versionedparcelable.VersionedParcelize
import kotlinx.parcelize.Parcelize

@Parcelize
data class CharacterInfo (
    val id : Long,
    val name: String,
    val  description : String,
    val image: String
): Parcelable

@Parcelize
data class CharacterListModel(
    val results: List<CharacterInfo>
): Parcelable
