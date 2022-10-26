package br.com.dnassuncao.pokemonapp.presentation.home.viewmodel

import br.com.dnassuncao.domain.model.Pokemon
import br.com.dnassuncao.pokemonapp.ui.common.UiStatus

data class HomeUiState(
    val status: UiStatus = UiStatus.Loading,
    val pokemonList: List<Pokemon> = emptyList()
)
