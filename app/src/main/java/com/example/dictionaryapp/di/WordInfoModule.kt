package com.example.dictionaryapp.di

import android.app.Application
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.dictionaryapp.data.converters.Converters
import com.example.dictionaryapp.data.local.WordInfoDao
import com.example.dictionaryapp.data.local.WordInfoDatabase
import com.example.dictionaryapp.data.remote.DictionaryAPI
import com.example.dictionaryapp.data.remote.DictionaryAPI.Companion.BASE_URL
import com.example.dictionaryapp.data.repositoryImpl.WordInfoRepoImpl
import com.example.dictionaryapp.data.util.GsonParser
import com.example.dictionaryapp.domain.repository.WordIfoRepository
import com.example.dictionaryapp.domain.usecase.WordInfoUsecase
import com.google.gson.Gson
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object WordInfoModule {

    @Provides
    @Singleton
    fun providesWordRepository(dao: WordInfoDatabase, api: DictionaryAPI): WordIfoRepository = WordInfoRepoImpl(dao.dao, api)

    @Provides
    @Singleton
    fun providesWordInfoDatabase(app: Application) = Room.databaseBuilder(
        context = app, klass = WordInfoDatabase::class.java, name = "word_db"
    ).addTypeConverter(Converters(GsonParser(Gson()))).fallbackToDestructiveMigration().build()

    @Provides
    @Singleton
    fun providesWordInfoAPI() = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(DictionaryAPI::class.java)

}
