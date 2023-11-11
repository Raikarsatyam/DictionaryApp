package com.example.dictionaryapp.data.repositoryImpl

import com.example.dictionaryapp.Util.Resource
import com.example.dictionaryapp.data.local.WordInfoDao
import com.example.dictionaryapp.data.remote.DictionaryAPI
import com.example.dictionaryapp.domain.model.WordInfo
import com.example.dictionaryapp.domain.repository.WordIfoRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import okio.IOException
import retrofit2.HttpException
import javax.inject.Inject

class WordInfoRepoImpl @Inject constructor (
    private val dao: WordInfoDao,
    private val api: DictionaryAPI
) : WordIfoRepository {
    override suspend fun getWordInfo(word: String): Flow<Resource<List<WordInfo>>> = flow {
        emit(Resource.Loading())

        val wordInfo = dao.getWordInfos(word).map { it.toWordInfo() }
        emit(Resource.Loading(data = wordInfo))

        try {
            val remoteWordInfo = api.getWordInfo(word = word)
            dao.deleteWordInfos(remoteWordInfo.map { it.word })
            dao.insertWordInfos(remoteWordInfo.map { it.toWordInfoEntity() })
        } catch (http: HttpException) {
            emit(Resource.Error(data = wordInfo, message = "Oops, network issue"))
        } catch (io: IOException) {
            emit(Resource.Error(data = wordInfo, message = "could reach server"))
        }
        val newWordInfo = dao.getWordInfos(word).map { it.toWordInfo() }
        emit(Resource.Success(data = newWordInfo))
    }
}