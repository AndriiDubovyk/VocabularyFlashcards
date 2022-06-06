package com.example.vocabularyflashcards.feature_vocabulary.presentation

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.vocabularyflashcards.feature_vocabulary.presentation.add_edit_flashcard.AddEditFlashcardScreen
import com.example.vocabularyflashcards.feature_vocabulary.presentation.flashcard_list.FlashcardScreen
import com.example.vocabularyflashcards.feature_vocabulary.presentation.util.Routes
import com.example.vocabularyflashcards.ui.theme.VocabularyFlashcardsTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            VocabularyFlashcardsTheme {
                val navController = rememberNavController()
                NavHost(
                    navController = navController,
                    startDestination = Routes.FLASHCARD_LIST
                ) {
                    composable(Routes.FLASHCARD_LIST) {
                        FlashcardScreen(
                            onNavigate = {
                                navController.navigate(it.route)
                            }
                        )
                    }
                    composable(
                        route = Routes.ADD_EDIT_FLASHCARD+"?flashcardId={flashcardId}",
                        arguments = listOf(
                            navArgument(name = "flashcardId") {
                                type = NavType.IntType
                                defaultValue = -1
                            }
                        )
                    ) {
                        AddEditFlashcardScreen(onPopBackStack = {
                            navController.popBackStack()
                        })
                    }

                }
            }
        }
    }
}