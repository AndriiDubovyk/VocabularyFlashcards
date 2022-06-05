package com.example.vocabularyflashcards.feature_vocabulary.data.local

import androidx.room.TypeConverter


class Converters{

    @TypeConverter
    fun fromString(stringValue: String): List<String> {
        return stringValue.split(",").map { it }
    }

    @TypeConverter
    fun fromList(listOfStrings: List<String>): String {
        return listOfStrings.joinToString(separator = ",")
    }
}