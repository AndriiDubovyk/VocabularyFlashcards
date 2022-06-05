package com.example.vocabularyflashcards.feature_vocabulary.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.vocabularyflashcards.feature_vocabulary.domain.model.Flashcard

@Database(
    entities = [Flashcard::class],
    version = 1
)
@TypeConverters(Converters::class)
abstract class FlashcardDatabase: RoomDatabase() {
    abstract val flashcardDao: FlashcardDao

    companion object {
        const val DATABASE_NAME = "flashcards_db"
    }
}