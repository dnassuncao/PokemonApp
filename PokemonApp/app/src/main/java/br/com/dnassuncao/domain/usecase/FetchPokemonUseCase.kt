package br.com.dnassuncao.domain.usecase

import br.com.dnassuncao.domain.model.Pokemon

interface FetchPokemonUseCase {
    suspend operator fun invoke(): Result<List<Pokemon>>
}