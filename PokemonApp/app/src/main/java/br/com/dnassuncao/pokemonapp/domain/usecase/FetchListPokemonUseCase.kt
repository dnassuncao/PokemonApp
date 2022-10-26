package br.com.dnassuncao.pokemonapp.domain.usecase

import br.com.dnassuncao.pokemonapp.domain.model.Pokemon
import kotlinx.coroutines.flow.Flow

interface FetchListPokemonUseCase {
    suspend operator fun invoke(): Flow<List<Pokemon>>
}