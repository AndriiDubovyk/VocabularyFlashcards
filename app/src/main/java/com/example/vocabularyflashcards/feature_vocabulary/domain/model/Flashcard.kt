package com.example.vocabularyflashcards.feature_vocabulary.domain.model

data class Flashcard(
    val word: String,
    val partOfSpeech: String,
    val translations: List<String>,
    val score: Int = 0, // represent user score for this word
    val id: Int? = null
)
