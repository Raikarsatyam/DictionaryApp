package com.example.dictionaryapp.data.util

import java.lang.reflect.Type

interface JsonParser {
    fun <T> toJson(t: T, type: Type): String?
    fun <T> fromJson(t: String, type: Type): T?
}