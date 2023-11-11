package com.example.dictionaryapp.data.util

import com.google.gson.Gson
import java.lang.reflect.Type

class GsonParser(
    private val gson: Gson
): JsonParser {
    override fun <T> toJson(t: T, type: Type): String? = gson.toJson(t, type)
    override fun <T> fromJson(t: String, type: Type): T? = gson.fromJson(t, type)
}