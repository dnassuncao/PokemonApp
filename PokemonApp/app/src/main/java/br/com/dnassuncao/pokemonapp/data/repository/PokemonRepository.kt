package br.com.dnassuncao.pokemonapp.data.repository

import br.com.dnassuncao.pokemonapp.data.entity.PokemonResponseList
import br.com.dnassuncao.pokemonapp.domain.model.Pokemon
import kotlinx.coroutines.flow.Flow

interface PokemonRepository {
    suspend fun fetchPokemonList(limit: Int?, offset: Int): PokemonResponseList
    suspend fun fetchPokemonDetail(pokemonId: String): Flow<Pokemon>
}