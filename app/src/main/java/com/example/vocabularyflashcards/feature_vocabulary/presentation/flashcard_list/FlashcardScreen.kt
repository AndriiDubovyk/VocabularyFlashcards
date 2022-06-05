package com.example.vocabularyflashcards.feature_vocabulary.presentation.flashcard_list


import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.vocabularyflashcards.feature_vocabulary.presentation.flashcard_list.components.FlashcardItem
import com.example.vocabularyflashcards.ui.theme.Purple

@Composable
fun FlashcardScreen(
    viewModel: FlashcardListViewModel = hiltViewModel()
) {

    val state = viewModel.state.value
    val scaffoldState = rememberScaffoldState()
    val scope = rememberCoroutineScope()

    Scaffold(
        scaffoldState = scaffoldState,
        floatingActionButton = {
            FloatingActionButton(
                onClick = {/*TODO*/},
                backgroundColor = Purple
            ) {
                Icon(imageVector = Icons.Default.Add, contentDescription = "Add flashcard")
            }
        }
    ) {
        LazyVerticalGrid(
            modifier = Modifier
                .padding(it),
            verticalArrangement = Arrangement.spacedBy(12.dp),
            horizontalArrangement = Arrangement.spacedBy(12.dp),
            columns = GridCells.Fixed(2),
            contentPadding = PaddingValues(start = 8.dp, end = 8.dp, top = 12.dp, bottom = 40.dp),
        ) {
            items(state.flashcards) { flashcard ->
                FlashcardItem(flashcard = flashcard)
            }
        }
    }
    
}