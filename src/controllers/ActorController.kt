package com.example.controllers


import com.example.domain.Actor
import com.example.services.ActorService

class ActorController {

    fun getAllActors(): Iterable<Actor> {
        return ActorService().getAllActors()
    }
    fun createActor(actor:Actor){
        ActorService().createActor(actor)
    }
}