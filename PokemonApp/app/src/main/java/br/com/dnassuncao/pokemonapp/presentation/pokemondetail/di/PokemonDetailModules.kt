package br.com.dnassuncao.pokemonapp.presentation.pokemondetail.di

import br.com.dnassuncao.pokemonapp.presentation.pokemondetail.viewmodel.PokemonDetailViewModel
import br.com.dnassuncao.pokemonapp.presentation.pokemonlist.viewmodel.PokemonListViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val presentationDetailModule = module {
    viewModel { PokemonDetailViewModel(get()) }
}