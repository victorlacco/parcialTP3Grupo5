package ar.edu.ort.parcialtp3_g5.interfaces

import ar.edu.ort.parcialtp3_g5.data.RickAndMortyResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface rickandmortyAPI {

    @GET("api/character")
    fun getAllCharacters(): Call<RickAndMortyResponse?>?

    @GET("api/character/2")
    fun getCharacter(): Call<RickAndMortyResponse?>?

    @GET("api/character/3,5")
    fun getCharacters(): Call<RickAndMortyResponse?>?

    @GET("api/character")
    fun getSearchCharacters(@Query("name") name: String):
            Call<RickAndMortyResponse?>?
}