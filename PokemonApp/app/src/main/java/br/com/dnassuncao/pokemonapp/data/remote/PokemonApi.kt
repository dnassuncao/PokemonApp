package br.com.dnassuncao.pokemonapp.data.remote

import br.com.dnassuncao.pokemonapp.data.entity.PokemonResponse
import br.com.dnassuncao.pokemonapp.domain.model.Pokemon
import retrofit2.http.GET

interface PokemonApi {
    @GET("pokemon")
    suspend fun fetchPokemons(): List<PokemonResponse>

    @GET("pokemon/{pokemon}")
    suspend fun fetchPokemonDetails(): Pokemon
}