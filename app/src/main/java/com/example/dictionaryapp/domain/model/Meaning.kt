package com.example.dictionaryapp.domain.model


data class Meaning(
    val definition: List<Definition>,
    val partOfSpeech: String
)