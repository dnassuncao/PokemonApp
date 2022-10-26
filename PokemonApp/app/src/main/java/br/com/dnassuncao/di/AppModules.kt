package br.com.dnassuncao.di

import br.com.dnassuncao.data.di.dataModule
import br.com.dnassuncao.domain.di.useCaseModule
import br.com.dnassuncao.network.di.networkModule
import br.com.dnassuncao.pokemonapp.presentation.home.di.presentationModule

object AppModules {
    val modules = listOf(presentationModule, useCaseModule, dataModule, networkModule)
}