package com.example.dictionaryapp.domain.model


import com.example.dictionaryapp.data.remote.dto.MeaningDto
import com.example.dictionaryapp.data.remote.dto.PhoneticDto
import com.google.gson.annotations.SerializedName

data class WordInfo(
    val meanings: List<Meaning>,
    val origin: String,
    val phonetic: String,
    val word: String
)