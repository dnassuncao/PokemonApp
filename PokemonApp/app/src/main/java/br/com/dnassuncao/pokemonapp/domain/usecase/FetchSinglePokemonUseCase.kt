package br.com.dnassuncao.pokemonapp.domain.usecase

import br.com.dnassuncao.pokemonapp.domain.model.Pokemon
import kotlinx.coroutines.flow.Flow

interface FetchSinglePokemonUseCase {
    suspend operator fun invoke(pokemonId: String): Flow<Pokemon>
}