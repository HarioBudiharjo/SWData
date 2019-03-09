package com.hariobudiharjo.swdata.Model

data class Films (
    val count: Long,
    val next: Any? = null,
    val previous: Any? = null,
    val results: List<ResultFilm>
)

data class ResultFilm (
    val title: String,
    val episodeID: Long,
    val openingCrawl: String,
    val director: String,
    val producer: String,
    val releaseDate: String,
    val characters: List<String>,
    val planets: List<String>,
    val starships: List<String>,
    val vehicles: List<String>,
    val species: List<String>,
    val created: String,
    val edited: String,
    val url: String
)
