package com.example.services

import com.example.data.Actors
import com.example.data.FilmActors
import com.example.data.Films
import com.example.domain.FilmActor
import org.jetbrains.exposed.sql.JoinType
import org.jetbrains.exposed.sql.selectAll
import org.jetbrains.exposed.sql.transactions.transaction

class FilmService {
    fun getFilmActors(): Iterable<FilmActor> = transaction {
        val filmActorList = mutableListOf<FilmActor>()
        Films.join(FilmActors, onColumn = Films.id, otherColumn = FilmActors.filmId, joinType = JoinType.INNER)
            .join(Actors, onColumn = Actors.id, otherColumn = FilmActors.actorId, joinType = JoinType.INNER)
            .selectAll().limit(5).forEach {
                    row->
                val filmActor = FilmActor()
                filmActor.filmName = row[Films.title]
                filmActor.actorName = row[Actors.firstName].plus(" ").plus(row[Actors.lastName])
                filmActor.rating = row[Films.rating]
                filmActor.rentalCost = row[Films.rentalRate].toDouble()
                filmActorList.add(filmActor)
            }
        filmActorList
    }
}