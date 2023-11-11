package com.example.dictionaryapp.data.remote.dto


import com.example.dictionaryapp.domain.model.Meaning
import com.google.gson.annotations.SerializedName

data class MeaningDto(
    @SerializedName("definitions")
    val definition: List<DefinitionDto>,
    @SerializedName("partOfSpeech")
    val partOfSpeech: String?
) {
    fun toMeaning() = Meaning(
        definition = definition.map { it.toDefinition() },
        partOfSpeech = partOfSpeech ?: ""
    )
}