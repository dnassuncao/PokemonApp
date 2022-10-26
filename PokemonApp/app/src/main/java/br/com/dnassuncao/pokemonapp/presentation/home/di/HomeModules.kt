package br.com.dnassuncao.pokemonapp.presentation.home.di

import br.com.dnassuncao.pokemonapp.presentation.home.viewmodel.HomeViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val presentationModule = module {
    viewModel { HomeViewModel(get()) }
}