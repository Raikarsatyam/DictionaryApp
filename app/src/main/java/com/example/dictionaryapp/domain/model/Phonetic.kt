package com.example.dictionaryapp.domain.model


import com.google.gson.annotations.SerializedName

data class Phonetic(
    val audio: String,
    val text: String
)