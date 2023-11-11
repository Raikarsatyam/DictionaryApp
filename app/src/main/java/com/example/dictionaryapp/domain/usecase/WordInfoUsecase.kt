package com.example.dictionaryapp.domain.usecase

import com.example.dictionaryapp.Util.Resource
import com.example.dictionaryapp.domain.model.WordInfo
import com.example.dictionaryapp.domain.repository.WordIfoRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class WordInfoUsecase @Inject constructor(
    private val wordIfoRepository: WordIfoRepository
) {
    suspend operator fun invoke(word: String): Flow<Resource<List<WordInfo>>> {
        if (word.isBlank())
            return flow {  }
        return wordIfoRepository.getWordInfo(word = word)
    }

}
