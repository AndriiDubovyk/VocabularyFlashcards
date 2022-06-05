package com.example.vocabularyflashcards.feature_vocabulary.presentation.flashcard_list

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.vocabularyflashcards.feature_vocabulary.domain.use_case.FlashcardUseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class FlashcardListViewModel @Inject constructor(
    private val flashcardUseCases: FlashcardUseCases
) : ViewModel() {

    private val _state = mutableStateOf(FlashcardListState())
    val state: State<FlashcardListState> = _state

    init {
        getFlashcards()
    }

    fun onAction(event: FlashcardListEvent) {
        when(event) {
            is FlashcardListEvent.DeleteFlashcard -> {
                viewModelScope.launch {
                    flashcardUseCases.deleteFlashcard(event.flashcard)
                }
            }
        }
    }

    private fun getFlashcards() {
        flashcardUseCases.getFlashcards()
            .onEach { flashcards ->
                _state.value = state.value.copy(
                    flashcards = flashcards
                )
            }.launchIn(viewModelScope)
    }

}