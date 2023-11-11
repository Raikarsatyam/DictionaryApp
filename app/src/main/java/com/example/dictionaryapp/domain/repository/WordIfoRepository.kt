package com.example.dictionaryapp.domain.repository

import com.example.dictionaryapp.Util.Resource
import com.example.dictionaryapp.domain.model.WordInfo
import kotlinx.coroutines.flow.Flow

interface WordIfoRepository {
     suspend fun getWordInfo(word: String): Flow<Resource<List<WordInfo>>>
}