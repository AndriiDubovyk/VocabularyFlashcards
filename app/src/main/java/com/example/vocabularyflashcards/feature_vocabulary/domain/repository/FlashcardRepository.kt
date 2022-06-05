package com.example.vocabularyflashcards.feature_vocabulary.domain.repository

import com.example.vocabularyflashcards.feature_vocabulary.domain.model.Flashcard
import kotlinx.coroutines.flow.Flow

interface FlashcardRepository {

    fun getFlashcard(): Flow<List<Flashcard>>

    suspend fun getFlashcardById(id: Int): Flashcard?

    suspend fun insertFlashcard(flashcard: Flashcard)

    suspend fun deleteFlashcard(flashcard: Flashcard)

}