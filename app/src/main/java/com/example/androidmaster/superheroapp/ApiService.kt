package com.example.androidmaster.superheroapp

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {

    @GET("e389d396695302f682efbd91bfd49eb1/search/{name}")
    suspend fun getSuperHeroes(@Path("name") superheroName: String): Response<SuperHeroDataResponse>

    @GET("e389d396695302f682efbd91bfd49eb1/{id}")
    suspend fun getSuperheroDetail(@Path("id") superheroId:String) : Response<SuperheroDetailResponse>
}