package com.example.vocabularyflashcards.feature_vocabulary.domain.use_case

import com.example.vocabularyflashcards.feature_vocabulary.domain.model.Flashcard
import com.example.vocabularyflashcards.feature_vocabulary.domain.repository.FlashcardRepository

class GetFlashcard(
    private val repository: FlashcardRepository
) {

    suspend operator fun invoke(id: Int): Flashcard? {
        return repository.getFlashcardById(id)
    }

}