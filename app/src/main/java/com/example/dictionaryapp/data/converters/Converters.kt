package com.example.dictionaryapp.data.converters


import androidx.room.ProvidedTypeConverter
import androidx.room.TypeConverter
import com.example.dictionaryapp.data.util.JsonParser
import com.example.dictionaryapp.domain.model.Meaning
import com.google.gson.reflect.TypeToken

@ProvidedTypeConverter
class Converters(
    private val jsonParser: JsonParser
) {
    @TypeConverter
    fun toMeaningsJson(meaning: List<Meaning>): String =
        jsonParser.toJson(
            t = meaning,
            type = object : TypeToken<ArrayList<Meaning>>(){}.type
        ) ?: "[]"

    @TypeConverter
    fun fromMeaningsJson(json: String): List<Meaning> =
        jsonParser.fromJson<ArrayList<Meaning>>(
            json,
            object : TypeToken<ArrayList<Meaning>>(){}.type
        ) ?: emptyList()
}