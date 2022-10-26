package br.com.dnassuncao.pokemonapp.domain.usecase

import br.com.dnassuncao.pokemonapp.data.repository.PokemonRepository
import br.com.dnassuncao.pokemonapp.domain.model.Pokemon
import kotlinx.coroutines.flow.Flow

class FetchPokemonUseCaseImpl(
    private val pokemonRepository: PokemonRepository
) : FetchPokemonUseCase {
    override suspend fun invoke(): Flow<List<Pokemon>> = pokemonRepository.fetchPokemons()
}
