package com.example.controllers

import com.example.domain.FilmActor
import com.example.services.FilmService

class FilmController {
    fun getFilmActors(): Iterable<FilmActor> {
        return FilmService().getFilmActors()
    }
}