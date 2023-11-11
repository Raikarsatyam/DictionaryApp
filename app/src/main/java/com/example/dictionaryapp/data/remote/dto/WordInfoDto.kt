package com.example.dictionaryapp.data.remote.dto


import com.example.dictionaryapp.data.local.entity.WordInfoEntity
import com.example.dictionaryapp.domain.model.WordInfo
import com.google.gson.annotations.SerializedName

data class WordInfoDto(
    @SerializedName("meanings")
    val meanings: List<MeaningDto>,
    @SerializedName("origin")
    val origin: String?,
    @SerializedName("phonetic")
    val phonetic: String?,
    @SerializedName("phonetics")
    val phonetics: List<PhoneticDto>,
    @SerializedName("word")
    val word: String
) {
    fun toWordInfoEntity() = WordInfoEntity(
        meanings = meanings.map { it.toMeaning() },
        origin = origin ?: "",
        phonetic = phonetic ?: "",
        word = word
    )
}