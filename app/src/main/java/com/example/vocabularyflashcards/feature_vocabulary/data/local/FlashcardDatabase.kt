package com.example.vocabularyflashcards.feature_vocabulary.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.vocabularyflashcards.feature_vocabulary.domain.model.Flashcard

@Database(
    entities = [Flashcard::class],
    version = 1
)
abstract class FlashcardDatabase: RoomDatabase() {
    abstract val flashcardDao: FlashcardDao

    companion object {
        const val DATABASE_NAME = "flashcards_db"
    }
}