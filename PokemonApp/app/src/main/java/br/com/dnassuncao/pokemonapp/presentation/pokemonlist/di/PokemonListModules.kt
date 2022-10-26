package br.com.dnassuncao.pokemonapp.presentation.pokemonlist.di

import br.com.dnassuncao.pokemonapp.presentation.pokemonlist.viewmodel.PokemonListViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val presentationListModule = module {
    viewModel { PokemonListViewModel(get()) }
}