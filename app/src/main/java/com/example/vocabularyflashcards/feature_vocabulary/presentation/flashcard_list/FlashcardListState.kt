package com.example.vocabularyflashcards.feature_vocabulary.presentation.flashcard_list

import com.example.vocabularyflashcards.feature_vocabulary.domain.model.Flashcard

data class FlashcardListState(
    val flashcards: List<Flashcard> = emptyList()
)
