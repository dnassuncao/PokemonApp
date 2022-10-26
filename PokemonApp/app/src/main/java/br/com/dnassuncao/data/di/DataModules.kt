package br.com.dnassuncao.data.di

import br.com.dnassuncao.data.repository.PokemonRepository
import br.com.dnassuncao.data.repository.PokemonRepositoryImpl
import org.koin.dsl.module

val dataModule = module {

    single<PokemonRepository> {
        PokemonRepositoryImpl(get())
    }
}