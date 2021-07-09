package com.example.services

import com.example.data.Actors
import com.example.domain.Actor
import org.jetbrains.exposed.sql.insert
import org.jetbrains.exposed.sql.selectAll
import org.jetbrains.exposed.sql.transactions.transaction

class ActorService {
    fun getAllActors(): Iterable<Actor> = transaction {
        val actorList = mutableListOf<Actor>()
        Actors.selectAll().map {
            val actor = Actor()
            actor.firstName = it[Actors.firstName]
            actor.lastName = it[Actors.lastName]
            actorList.add(actor)
        }
        actorList
    }

    fun createActor(actor: Actor) = transaction {
        Actors.insert {
            it[firstName] = actor.firstName
            it[lastName] = actor.lastName
        }
    }
}