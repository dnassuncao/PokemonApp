package br.com.dnassuncao.pokemonapp.presentation.pokemonlist.viewmodel

sealed class PokemonListNavigationRequest {
    data class PokemonDetailScreen(val pokemonId: String) : PokemonListNavigationRequest()
}
