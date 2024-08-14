package com.example.androidmaster.superheroapp

import com.google.gson.annotations.SerializedName

data class SuperHeroDataResponse(
    @SerializedName("response") val response:String,
    @SerializedName("results-for") val resultsFor: String,
    @SerializedName("results") val superheroes: List<SuperHeroItemResponse>
)

data class SuperHeroItemResponse(
    @SerializedName("id") val superheroId: String,
    @SerializedName("name") val name: String,
    @SerializedName("image") val superheroImage:SuperheroImageResponse
)

data class SuperheroImageResponse(
    @SerializedName("url") val url:String
)
//A partir de la respuesta de la API se configura el objeto que va a tomar los datos para mostrar en la app