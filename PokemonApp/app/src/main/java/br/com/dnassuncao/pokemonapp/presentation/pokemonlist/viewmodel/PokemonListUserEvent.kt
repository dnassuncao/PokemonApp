package br.com.dnassuncao.pokemonapp.presentation.pokemonlist.viewmodel

sealed class PokemonListUserEvent {
    object OnInitScreen : PokemonListUserEvent()
    data class OnItemClick(val pokemonId: String) : PokemonListUserEvent()
    data class OnSearchPokemon(val pokemonName: String) : PokemonListUserEvent()
}
