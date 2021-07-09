package com.example.data

import org.jetbrains.exposed.sql.Table

object Actors: Table("actor"){
    val id = integer("actor_id")
    val firstName = varchar("first_name", 255)
    val lastName = varchar("last_name", 255)
}
