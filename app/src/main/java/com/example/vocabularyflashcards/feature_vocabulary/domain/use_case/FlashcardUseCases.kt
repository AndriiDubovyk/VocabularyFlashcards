package com.example.vocabularyflashcards.feature_vocabulary.domain.use_case

data class FlashcardUseCases(
    val addFlashcard: AddFlashcard,
    val deleteFlashcard: DeleteFlashcard,
    val getFlashcard: GetFlashcard,
    val getFlashcards: GetFlashcards
)
