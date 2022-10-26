package br.com.dnassuncao.pokemonapp.presentation.home.viewmodel

sealed class HomeUserEvent {
    object OnInitScreen : HomeUserEvent()
    object OnItemClick : HomeUserEvent()
    data class OnSearchPokemon(val pokemonName: String) : HomeUserEvent()
}
