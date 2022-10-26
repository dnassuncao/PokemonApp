package br.com.dnassuncao.domain.usecase

import br.com.dnassuncao.data.repository.PokemonRepository
import br.com.dnassuncao.domain.model.Pokemon

class FetchPokemonUseCaseImpl(
    private val pokemonRepository: PokemonRepository
) : FetchPokemonUseCase {
    override suspend fun invoke(): Result<List<Pokemon>> = pokemonRepository.fetchPokemons()
}
