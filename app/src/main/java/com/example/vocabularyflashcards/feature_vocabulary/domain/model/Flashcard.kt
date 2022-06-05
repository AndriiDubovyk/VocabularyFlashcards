package com.example.vocabularyflashcards.feature_vocabulary.domain.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Flashcard(
    val word: String,
    val partOfSpeech: String,
    val translations: List<String>,
    val score: Int = 0, // represent user score for this word
    @PrimaryKey val id: Int? = null
)
