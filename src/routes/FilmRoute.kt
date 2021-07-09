package com.example.routes

import com.example.controllers.FilmController
import io.ktor.application.*
import io.ktor.http.*
import io.ktor.response.*
import io.ktor.routing.*

fun Route.films(){
    get("filmactors"){
        val filmController = FilmController()
        val filmActorList = filmController.getFilmActors()
        call.respond(message = filmActorList, status = HttpStatusCode.OK)
    }
}