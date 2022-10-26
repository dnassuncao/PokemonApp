package br.com.dnassuncao.pokemonapp.domain.usecase

import br.com.dnassuncao.pokemonapp.data.repository.PokemonRepository
import br.com.dnassuncao.pokemonapp.domain.model.Pokemon
import kotlinx.coroutines.flow.Flow

class FetchListPokemonUseCaseImpl(
    private val pokemonRepository: PokemonRepository
) : FetchListPokemonUseCase {
    override suspend fun invoke(): Flow<List<Pokemon>> = pokemonRepository.fetchPokemonList()
}
