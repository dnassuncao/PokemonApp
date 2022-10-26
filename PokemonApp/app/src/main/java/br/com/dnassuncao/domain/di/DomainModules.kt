package br.com.dnassuncao.domain.di

import br.com.dnassuncao.domain.usecase.FetchPokemonUseCase
import br.com.dnassuncao.domain.usecase.FetchPokemonUseCaseImpl
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