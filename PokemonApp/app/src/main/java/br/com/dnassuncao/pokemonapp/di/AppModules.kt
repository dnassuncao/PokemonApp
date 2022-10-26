package br.com.dnassuncao.pokemonapp.di

import br.com.dnassuncao.pokemonapp.data.di.dataModule
import br.com.dnassuncao.pokemonapp.domain.di.useCaseModule
import br.com.dnassuncao.pokemonapp.network.di.networkModule
import br.com.dnassuncao.pokemonapp.presentation.pokemondetail.di.presentationDetailModule
import br.com.dnassuncao.pokemonapp.presentation.pokemonlist.di.presentationListModule

object AppModules {
    val modules = listOf(
        presentationListModule,
        presentationDetailModule,
        useCaseModule,
        dataModule,
        networkModule
    )
}