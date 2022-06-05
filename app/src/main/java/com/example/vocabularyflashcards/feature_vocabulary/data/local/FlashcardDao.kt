package com.example.vocabularyflashcards.feature_vocabulary.data.local

import androidx.room.*
import com.example.vocabularyflashcards.feature_vocabulary.domain.model.Flashcard
import kotlinx.coroutines.flow.Flow

@Dao
interface FlashcardDao {

    @Query("SELECT * FROM flashcard")
    fun getFlashcards(): Flow<List<Flashcard>>

    @Query("SELECT * FROM flashcard WHERE id = :id")
    suspend fun getFlashcardById(id: Int): Flashcard?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertFlashcard(flashcard: Flashcard)

    @Delete
    suspend fun deleteFlashcard(flashcard: Flashcard)

}