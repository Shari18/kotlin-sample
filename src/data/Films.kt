package com.example.data

import org.jetbrains.exposed.sql.Table

object Films : Table("film"){
    val id = integer("film_id")
    val title = varchar("title", 255)
    val description = text("description")
    val releaseYear = integer("release_year")
    val languageId = integer("language_id")
    val originalLanguageId = integer("original_language_id")
    val rentalDuration = integer("rental_duration")
    val rentalRate = decimal("rental_rate", 4,2)
    val length = integer("length")
    val replacementCost = decimal("replacement_cost", 5,2)
    val rating = varchar("rating", 10)
    val specialFeatures = varchar("special_features", 255)
}