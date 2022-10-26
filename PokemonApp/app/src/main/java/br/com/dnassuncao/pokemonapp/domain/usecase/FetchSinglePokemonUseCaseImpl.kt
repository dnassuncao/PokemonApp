package br.com.dnassuncao.pokemonapp.domain.usecase

import br.com.dnassuncao.pokemonapp.data.repository.PokemonRepository
import br.com.dnassuncao.pokemonapp.domain.model.Pokemon
import kotlinx.coroutines.flow.Flow

class FetchSinglePokemonUseCaseImpl(
    private val pokemonRepository: PokemonRepository
) : FetchSinglePokemonUseCase {
    override suspend fun invoke(pokemonId: String): Flow<Pokemon> = pokemonRepository.fetchPokemonDetail(pokemonId)
}
