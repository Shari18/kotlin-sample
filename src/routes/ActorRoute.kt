package com.example.routes

import com.example.controllers.ActorController
import com.example.domain.Actor
import io.ktor.application.*
import io.ktor.http.*
import io.ktor.request.*
import io.ktor.response.*
import io.ktor.routing.*

fun Route.actors(){

    get("actors"){
        val actorController = ActorController()
        val allActors = actorController.getAllActors()
        with(call) {
            respond(allActors)
        }
    }
    post("actor"){
        val actor = call.receive<Actor>()
        val actorController = ActorController()
        actorController.createActor(actor)
        call.respond(HttpStatusCode.Accepted)
    }
}