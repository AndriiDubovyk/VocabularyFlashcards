package com.example.vocabularyflashcards.di

import android.app.Application
import androidx.room.Room
import com.example.vocabularyflashcards.feature_vocabulary.data.local.FlashcardDatabase
import com.example.vocabularyflashcards.feature_vocabulary.data.repository.FlashcardRepositoryImpl
import com.example.vocabularyflashcards.feature_vocabulary.domain.repository.FlashcardRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideFlashcardDatabase(app: Application): FlashcardDatabase {
        return Room.databaseBuilder(
            app,
            FlashcardDatabase::class.java,
            FlashcardDatabase.DATABASE_NAME
        ).build()
    }

    @Provides
    @Singleton
    fun provideFlashcardRepository(db: FlashcardDatabase): FlashcardRepository {
        return FlashcardRepositoryImpl(db.flashcardDao)
    }

}