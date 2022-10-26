package br.com.dnassuncao.pokemonapp.domain.di

import br.com.dnassuncao.pokemonapp.domain.usecase.FetchPokemonUseCase
import br.com.dnassuncao.pokemonapp.domain.usecase.FetchPokemonUseCaseImpl
import br.com.dnassuncao.pokemonapp.presentation.home.viewmodel.HomeViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val useCaseModule = module {
    single<FetchPokemonUseCase> {
        FetchPokemonUseCaseImpl(
            pokemonRepository = get()
        )
    }
}