package com.example.vocabularyflashcards.feature_vocabulary.presentation.add_edit_flashcard

sealed class AddEditFlashcardEvent  {
    data class OnWordChange(val word: String): AddEditFlashcardEvent()
    data class OnPartOfSpeechChange(val partOfSpeech: String): AddEditFlashcardEvent()
    data class OnTranslationsChange(val translations: List<String>): AddEditFlashcardEvent()
    object OnSaveFlashcardClick: AddEditFlashcardEvent()

}
