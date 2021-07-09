package com.example.data

import org.jetbrains.exposed.sql.Table

object FilmActors : Table("film_actor"){
    val filmId = integer("film_id").references(Films.id)
    val actorId = integer("actor_id").references(Actors.id)
}