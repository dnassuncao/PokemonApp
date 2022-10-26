package br.com.dnassuncao.pokemonapp.presentation.pokemondetail.viewmodel

sealed class PokemonDetailNavigationRequest {
    object PokemonDetailBack : PokemonDetailNavigationRequest()
}
