package com.hariobudiharjo.swdata.Model

data class Peoples (
    val count: Long,
    val next: String,
    val previous: Any? = null,
    val results: List<ResultPeople>
)

data class ResultPeople (
    val name: String,
    val height: String,
    val mass: String,
    val hairColor: String,
    val skinColor: String,
    val eyeColor: String,
    val birthYear: String,
    val gender: String,
    val homeworld: String,
    val films: List<String>,
    val species: List<String>,
    val vehicles: List<String>,
    val starships: List<String>,
    val created: String,
    val edited: String,
    val url: String
)