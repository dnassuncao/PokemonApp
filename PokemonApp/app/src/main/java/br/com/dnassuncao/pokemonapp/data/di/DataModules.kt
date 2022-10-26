package br.com.dnassuncao.pokemonapp.data.di

import br.com.dnassuncao.pokemonapp.data.repository.PokemonRepository
import br.com.dnassuncao.pokemonapp.data.repository.PokemonRepositoryImpl
import org.koin.dsl.module

val dataModule = module {

    single<PokemonRepository> {
        PokemonRepositoryImpl(get())
    }
}