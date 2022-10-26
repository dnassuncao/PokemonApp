package br.com.dnassuncao.pokemonapp.data.remote

import br.com.dnassuncao.pokemonapp.data.entity.PokemonResponse
import br.com.dnassuncao.pokemonapp.data.entity.PokemonResponseList
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface PokemonApi {
    @GET("pokemon")
    suspend fun fetchPokemons(
        @Query("limit") limit: Int?,
        @Query("offset") offset: Int?
    ): PokemonResponseList

    @GET("pokemon/{pokemon}")
    suspend fun fetchPokemonDetails(
        @Path("pokemon") pokemon: String,
    ): PokemonResponse
}