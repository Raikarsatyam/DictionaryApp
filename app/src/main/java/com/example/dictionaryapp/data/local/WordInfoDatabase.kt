package com.example.dictionaryapp.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.dictionaryapp.data.converters.Converters
import com.example.dictionaryapp.data.local.entity.WordInfoEntity


@Database(
    entities = [WordInfoEntity::class],
    version = 3,
    exportSchema = false
)
@TypeConverters(Converters::class)
abstract class WordInfoDatabase : RoomDatabase() {

    abstract val dao: WordInfoDao
}