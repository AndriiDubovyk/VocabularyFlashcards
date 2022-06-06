package com.example.vocabularyflashcards.feature_vocabulary.presentation.util

sealed class UiEvent {
    object PopBackStack: UiEvent()
    data class Navigate(val route: String): UiEvent()
}
