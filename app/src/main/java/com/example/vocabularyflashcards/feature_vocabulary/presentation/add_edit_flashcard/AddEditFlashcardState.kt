package com.example.vocabularyflashcards.feature_vocabulary.presentation.add_edit_flashcard

import com.example.vocabularyflashcards.feature_vocabulary.domain.model.Flashcard

data class AddEditFlashcardState(
    val flashcard: Flashcard? = null,
    val wordField: String = "",
    val partOfSpeechField: String = "",
    val translationsField: String = ""
)
