package br.com.dnassuncao.data.remote

import br.com.dnassuncao.domain.model.Pokemon
import retrofit2.http.GET

interface PokemonApi {
    @GET("pokemon")
    suspend fun fetchPokemons(): List<Pokemon>
}