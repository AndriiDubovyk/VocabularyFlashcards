package com.example.vocabularyflashcards.feature_vocabulary.domain.use_case

import com.example.vocabularyflashcards.feature_vocabulary.domain.model.Flashcard
import com.example.vocabularyflashcards.feature_vocabulary.domain.repository.FlashcardRepository
import kotlinx.coroutines.flow.Flow

class GetFlashcards(
    private val repository: FlashcardRepository
) {

    operator fun invoke(): Flow<List<Flashcard>> {
        return repository.getFlashcard()
    }

}