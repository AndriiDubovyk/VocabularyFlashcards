package com.example.vocabularyflashcards.feature_vocabulary.presentation.add_edit_flashcard

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.vocabularyflashcards.feature_vocabulary.domain.model.Flashcard
import com.example.vocabularyflashcards.feature_vocabulary.domain.use_case.FlashcardUseCases
import com.example.vocabularyflashcards.feature_vocabulary.presentation.util.UiEvent
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AddEditFlashcardViewModel @Inject constructor(
    private val flashcardUseCases: FlashcardUseCases,
    savedStateHandle: SavedStateHandle
) : ViewModel() {

    private val _state = mutableStateOf(AddEditFlashcardState())
    val state: State<AddEditFlashcardState> = _state

    private val _uiEvent = Channel<UiEvent>()
    val uiEvent = _uiEvent.receiveAsFlow()

    init {
        val flashcardId = savedStateHandle.get<Int>("flashcardId")!!
        if(flashcardId != -1) {
            viewModelScope.launch {
                flashcardUseCases.getFlashcard(flashcardId)?.let { flashcard ->
                    _state.value = state.value.copy(
                        flashcard = flashcard,
                        wordField = flashcard.word,
                        partOfSpeechField = flashcard.partOfSpeech,
                        translationsField = flashcard.translations.joinToString(separator = ",")
                    )
                }
            }
        }
    }

    fun onAction(event: AddEditFlashcardEvent) {
        when(event) {
            is AddEditFlashcardEvent.OnWordChange -> {
                _state.value = state.value.copy(wordField = event.word)
            }
            is AddEditFlashcardEvent.OnPartOfSpeechChange -> {
                _state.value = state.value.copy(partOfSpeechField = event.partOfSpeech)
            }
            is AddEditFlashcardEvent.OnTranslationsChange -> {
                _state.value = state.value.copy(translationsField = event.translations.joinToString(separator = ","))
            }
            is AddEditFlashcardEvent.OnSaveFlashcardClick -> {
                viewModelScope.launch {
                    flashcardUseCases.addFlashcard(
                        Flashcard(
                            word = state.value.wordField,
                            partOfSpeech = state.value.partOfSpeechField,
                            translations = state.value.translationsField.split("\n").map { it },
                            score = state.value.flashcard?.score ?: 0,
                            id = state.value.flashcard?.id
                        )
                    )
                    sendUiEvent(UiEvent.PopBackStack)
                }
            }
        }
    }

    private fun sendUiEvent(event: UiEvent) {
        viewModelScope.launch {
            _uiEvent.send(event)
        }
    }
}