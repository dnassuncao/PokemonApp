package br.com.dnassuncao.pokemonapp.presentation.pokemondetail.viewmodel

sealed class PokemonDetailUserEvent {
    data class OnInitScreen(val pokemonId: String) : PokemonDetailUserEvent()
}
