package com.hariobudiharjo.swdata.Model

data class Starships (
    val count: Long,
    val next: String,
    val previous: Any? = null,
    val results: List<ResultStarship>
)

data class ResultStarship (
    val name: String,
    val model: String,
    val manufacturer: String,
    val costInCredits: String,
    val length: String,
    val maxAtmospheringSpeed: String,
    val crew: String,
    val passengers: String,
    val cargoCapacity: String,
    val consumables: String,
    val hyperdriveRating: String,
    val mglt: String,
    val starshipClass: String,
    val pilots: List<String>,
    val films: List<String>,
    val created: String,
    val edited: String,
    val url: String
)
