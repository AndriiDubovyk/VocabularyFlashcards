package com.example.vocabularyflashcards.feature_vocabulary.data.repository

import com.example.vocabularyflashcards.feature_vocabulary.data.local.FlashcardDao
import com.example.vocabularyflashcards.feature_vocabulary.domain.model.Flashcard
import com.example.vocabularyflashcards.feature_vocabulary.domain.repository.FlashcardRepository
import kotlinx.coroutines.flow.Flow

class FlashcardRepositoryImpl(
    private val dao: FlashcardDao
): FlashcardRepository {

    override fun getFlashcard(): Flow<List<Flashcard>> {
        return dao.getFlashcards()
    }

    override suspend fun getFlashcardById(id: Int): Flashcard? {
        return dao.getFlashcardById(id)
    }

    override suspend fun insertFlashcard(flashcard: Flashcard) {
        dao.insertFlashcard(flashcard)
    }

    override suspend fun deleteFlashcard(flashcard: Flashcard) {
        dao.deleteFlashcard(flashcard)
    }
}