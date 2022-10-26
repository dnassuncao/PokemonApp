package br.com.dnassuncao.pokemonapp.data.repository

import br.com.dnassuncao.pokemonapp.data.mapper.toDomain
import br.com.dnassuncao.pokemonapp.data.remote.PokemonApi
import br.com.dnassuncao.pokemonapp.domain.model.Pokemon
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class PokemonRepositoryImpl(
    private val pokemonApi: PokemonApi
) : PokemonRepository {
    override suspend fun fetchPokemonList(): Flow<List<Pokemon>> = flow {
        val pokemonList = pokemonApi.fetchPokemons(
            limit = 50,
            offset = 1
        )
        emit(
            pokemonList.results.map { pokemonResult -> pokemonResult.toDomain() }
        )
    }

    override suspend fun fetchPokemonDetail(pokemonId: String): Flow<Pokemon> = flow {
        emit(
            pokemonApi.fetchPokemonDetails(pokemonId).toDomain()
        )
    }
}
