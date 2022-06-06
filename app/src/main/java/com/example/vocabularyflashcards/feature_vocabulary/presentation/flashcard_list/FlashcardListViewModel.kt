package com.example.vocabularyflashcards.feature_vocabulary.presentation.flashcard_list

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.vocabularyflashcards.feature_vocabulary.domain.use_case.FlashcardUseCases
import com.example.vocabularyflashcards.feature_vocabulary.presentation.util.Routes
import com.example.vocabularyflashcards.feature_vocabulary.presentation.util.UiEvent
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class FlashcardListViewModel @Inject constructor(
    private val flashcardUseCases: FlashcardUseCases
) : ViewModel() {

    private val _state = mutableStateOf(FlashcardListState())
    val state: State<FlashcardListState> = _state

    private val _uiEvent = Channel<UiEvent>()
    val uiEvent = _uiEvent.receiveAsFlow()

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
            is FlashcardListEvent.OnAddFlashcardClick -> {
                sendUiEvent(UiEvent.Navigate(Routes.ADD_EDIT_FLASHCARD))
            }
            is FlashcardListEvent.OnFlashcardClick -> {
                sendUiEvent(UiEvent.Navigate(Routes.ADD_EDIT_FLASHCARD+"?flashcardId=${event.flashcard.id}"))
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

    private fun sendUiEvent(event: UiEvent) {
        viewModelScope.launch {
            _uiEvent.send(event)
        }
    }

}