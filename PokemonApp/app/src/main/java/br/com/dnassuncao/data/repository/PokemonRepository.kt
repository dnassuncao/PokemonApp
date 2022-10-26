package br.com.dnassuncao.data.repository

import br.com.dnassuncao.domain.model.Pokemon

interface PokemonRepository {
    suspend fun fetchPokemons(): Result<List<Pokemon>>
}