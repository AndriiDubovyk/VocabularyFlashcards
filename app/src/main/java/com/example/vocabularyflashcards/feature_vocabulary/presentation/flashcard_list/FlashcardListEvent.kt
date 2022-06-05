package com.example.vocabularyflashcards.feature_vocabulary.presentation.flashcard_list

import com.example.vocabularyflashcards.feature_vocabulary.domain.model.Flashcard

sealed class FlashcardListEvent {
    data class DeleteFlashcard(val flashcard: Flashcard): FlashcardListEvent()
}