package br.com.dnassuncao.pokemonapp.data.repository

import br.com.dnassuncao.pokemonapp.domain.model.Pokemon
import kotlinx.coroutines.flow.Flow

interface PokemonRepository {
    suspend fun fetchPokemons(): Flow<List<Pokemon>>
}