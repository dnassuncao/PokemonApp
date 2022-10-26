package br.com.dnassuncao.pokemonapp.presentation.home.viewmodel

sealed class HomeNavigationRequest {
    object PokemonDetailScreen : HomeNavigationRequest()
}
