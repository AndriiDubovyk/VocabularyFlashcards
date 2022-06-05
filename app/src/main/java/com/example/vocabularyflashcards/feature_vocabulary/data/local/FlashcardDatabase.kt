package com.example.vocabularyflashcards.feature_vocabulary.data.local

import androidx.room.Database
import com.example.vocabularyflashcards.feature_vocabulary.domain.model.Flashcard

@Database(
    entities = [Flashcard::class],
    version = 1
)
abstract class FlashcardDatabase {
    abstract val flashcardDao: FlashcardDao
}