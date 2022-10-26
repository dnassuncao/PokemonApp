package br.com.dnassuncao.pokemonapp.presentation.pokemonlist.viewmodel

import br.com.dnassuncao.pokemonapp.domain.model.Pokemon
import br.com.dnassuncao.pokemonapp.ui.common.UiStatus

data class PokemonListUiState(
    val status: UiStatus? = null,
    val pokemonList: List<Pokemon> = emptyList()
)
