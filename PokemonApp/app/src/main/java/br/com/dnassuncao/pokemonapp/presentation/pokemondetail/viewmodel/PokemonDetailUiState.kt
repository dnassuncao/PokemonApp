package br.com.dnassuncao.pokemonapp.presentation.pokemondetail.viewmodel

import br.com.dnassuncao.pokemonapp.domain.model.Pokemon
import br.com.dnassuncao.pokemonapp.ui.common.UiStatus

data class PokemonDetailUiState(
    val status: UiStatus? = null,
    val pokemon: Pokemon? = null
)
