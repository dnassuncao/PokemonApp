package br.com.dnassuncao.pokemonapp.domain.di

import br.com.dnassuncao.pokemonapp.domain.usecase.FetchListPokemonUseCase
import br.com.dnassuncao.pokemonapp.domain.usecase.FetchListPokemonUseCaseImpl
import br.com.dnassuncao.pokemonapp.domain.usecase.FetchSinglePokemonUseCase
import br.com.dnassuncao.pokemonapp.domain.usecase.FetchSinglePokemonUseCaseImpl
import org.koin.dsl.module

val useCaseModule = module {

    single<FetchListPokemonUseCase> {
        FetchListPokemonUseCaseImpl(
            pokemonRepository = get()
        )
    }

    single<FetchSinglePokemonUseCase> {
        FetchSinglePokemonUseCaseImpl(
            pokemonRepository = get()
        )
    }
}