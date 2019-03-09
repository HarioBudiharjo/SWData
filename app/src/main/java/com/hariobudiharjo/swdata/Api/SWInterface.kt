package com.hariobudiharjo.swdata.Api

import com.hariobudiharjo.swdata.Model.*
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Url

interface SWInterface {
    @GET("api/people")
    @Headers("Accept: application/json")
    fun getPeoples(): Observable<Peoples>

    @GET("api/planets")
    @Headers("Accept: application/json")
    fun getPlanets(): Observable<Planets>

    @GET("api/films")
    @Headers("Accept: application/json")
    fun getFilms(): Observable<Films>

    @GET("api/species")
    @Headers("Accept: application/json")
    fun getSpecies(): Observable<Species>

    @GET("api/vehicles")
    @Headers("Accept: application/json")
    fun getVehicles(): Observable<Vehicles>

    @GET("api/starships")
    @Headers("Accept: application/json")
    fun getStarships(): Observable<Starships>

    //detail

    @GET
    @Headers("Accept: application/json")
    fun detailPeoples(@Url url : String): Observable<ResultPeople>

    @GET
    @Headers("Accept: application/json")
    fun detailPlanets(@Url url : String): Observable<ResultPlanet>

    @GET
    @Headers("Accept: application/json")
    fun detailFilms(@Url url : String): Observable<ResultFilm>

    @GET
    @Headers("Accept: application/json")
    fun detailSpecies(@Url url : String): Observable<ResultSpecie>

    @GET
    @Headers("Accept: application/json")
    fun detailVehicles(@Url url : String): Observable<ResultVehicle>

    @GET
    @Headers("Accept: application/json")
    fun detailStarships(@Url url : String): Observable<ResultStarship>


}