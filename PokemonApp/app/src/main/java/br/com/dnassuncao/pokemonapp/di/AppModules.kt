package br.com.dnassuncao.pokemonapp.di

import br.com.dnassuncao.pokemonapp.data.di.dataModule
import br.com.dnassuncao.pokemonapp.domain.di.useCaseModule
import br.com.dnassuncao.pokemonapp.network.di.networkModule
import br.com.dnassuncao.pokemonapp.presentation.home.di.presentationModule

object AppModules {
    val modules = listOf(presentationModule, useCaseModule, dataModule, networkModule)
}