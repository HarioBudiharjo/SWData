package com.hariobudiharjo.swdata.Model

data class Species (
    val count: Long,
    val next: String,
    val previous: Any? = null,
    val results: List<ResultSpecie>
)

data class ResultSpecie (
    val name: String,
    val classification: String,
    val designation: Designation,
    val averageHeight: String,
    val skinColors: String,
    val hairColors: String,
    val eyeColors: String,
    val averageLifespan: String,
    val homeworld: String,
    val language: String,
    val people: List<String>,
    val films: List<String>,
    val created: String,
    val edited: String,
    val url: String
)

enum class Designation {
    Sentient
}
