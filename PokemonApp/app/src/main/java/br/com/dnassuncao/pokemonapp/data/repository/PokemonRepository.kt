package br.com.dnassuncao.pokemonapp.data.repository

import br.com.dnassuncao.pokemonapp.domain.model.Pokemon
import kotlinx.coroutines.flow.Flow

interface PokemonRepository {
    suspend fun fetchPokemonList(): Flow<List<Pokemon>>
    suspend fun fetchPokemonDetail(pokemonId: String): Flow<Pokemon>
}