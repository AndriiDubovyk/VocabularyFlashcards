package com.example.vocabularyflashcards.feature_vocabulary.presentation.add_edit_flashcard

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.vocabularyflashcards.feature_vocabulary.presentation.util.UiEvent
import com.example.vocabularyflashcards.ui.theme.LightBlue
import com.example.vocabularyflashcards.ui.theme.Purple

@Composable
fun AddEditFlashcardScreen(
    onPopBackStack: () -> Unit,
    viewModel: AddEditFlashcardViewModel = hiltViewModel()
) {

    val state = viewModel.state.value
    val scaffoldState = rememberScaffoldState()

    LaunchedEffect(key1 = true) {
        viewModel.uiEvent.collect { event ->
            when(event) {
                is UiEvent.PopBackStack -> onPopBackStack()
                else -> Unit
            }
        }
    }

    Scaffold(
        scaffoldState = scaffoldState,
        modifier = Modifier
            .fillMaxSize(),
        floatingActionButton = {
            FloatingActionButton(
                onClick = { viewModel.onAction(AddEditFlashcardEvent.OnSaveFlashcardClick) },
                backgroundColor = Purple
            ) {
                Icon(imageVector = Icons.Default.Check, contentDescription = "Check")
            }
        }
    ) {

        Card(
            shape = RoundedCornerShape(topStart = 15.dp, topEnd = 15.dp),
            modifier = Modifier.
            padding(top = 15.dp, start = 10.dp, end = 10.dp).
            fillMaxSize(),
            elevation = 10.dp
        ) {
            Column(
                modifier =Modifier.
                fillMaxSize().
                background(LightBlue).
                padding(it)
            ) {
                TextField(
                    value = state.wordField,
                    onValueChange = {
                        viewModel.onAction(AddEditFlashcardEvent.OnWordChange(it))
                    },
                    placeholder = {
                        Text(text = "Word")
                    },
                    modifier = Modifier.fillMaxWidth(),
                    singleLine = true
                )
                Spacer(modifier = Modifier.height(8.dp))
                TextField(
                    value = state.partOfSpeechField,
                    onValueChange = {
                        viewModel.onAction(AddEditFlashcardEvent.OnPartOfSpeechChange(it))
                    },
                    placeholder = {
                        Text(text = "Part of speech")
                    },
                    modifier = Modifier.fillMaxWidth(),
                    singleLine = true,
                )
                Spacer(modifier = Modifier.height(8.dp))
                TextField(
                    value = state.translationsField,
                    onValueChange = {
                        viewModel.onAction(AddEditFlashcardEvent.OnTranslationsChange(it.split(",").map { it }))
                    },
                    placeholder = {
                        Text(text = "Each translation should be entered on separate line")
                    },
                    modifier = Modifier.fillMaxWidth(),
                    maxLines=7,
                )
            }
        }

    }

}
