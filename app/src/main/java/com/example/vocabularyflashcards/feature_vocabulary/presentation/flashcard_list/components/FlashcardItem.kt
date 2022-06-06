package com.example.vocabularyflashcards.feature_vocabulary.presentation.flashcard_list.components

import androidx.compose.foundation.background
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.vocabularyflashcards.feature_vocabulary.domain.model.Flashcard
import com.example.vocabularyflashcards.ui.theme.BLACK
import com.example.vocabularyflashcards.ui.theme.DarkGray
import com.example.vocabularyflashcards.ui.theme.LightBlue

@Composable
fun FlashcardItem(
    flashcard: Flashcard,
    modifier: Modifier = Modifier
) {
    val scroll = rememberScrollState(0)

    Card(
        shape = RoundedCornerShape(15.dp),
        modifier = modifier.
            width(180.dp),
        elevation = 10.dp
    ) {
        Column(
            modifier = Modifier.
            background(LightBlue).
            padding(vertical = 15.dp, horizontal = 10.dp)
        ) {
            Text(
                text = flashcard.word,
                fontWeight = FontWeight.Bold,
                fontSize = 22.sp,
                color = BLACK
            )
            Text(
                text = flashcard.partOfSpeech,
                fontStyle = FontStyle.Italic,
                fontSize = 18.sp,
                color = DarkGray
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = flashcard.translations.joinToString(", "),
                modifier = Modifier.horizontalScroll(scroll),
                fontSize = 19.sp,
                color = BLACK
            )
        }
    }
}