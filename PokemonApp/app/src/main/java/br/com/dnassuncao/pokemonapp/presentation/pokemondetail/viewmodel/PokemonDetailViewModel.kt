package br.com.dnassuncao.pokemonapp.presentation.pokemondetail.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.dnassuncao.pokemonapp.core.extensions.onError
import br.com.dnassuncao.pokemonapp.core.extensions.onSuccess
import br.com.dnassuncao.pokemonapp.domain.usecase.FetchSinglePokemonUseCase
import br.com.dnassuncao.pokemonapp.ui.common.UiStatus
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch

class PokemonDetailViewModel(
    private val fetchSinglePokemonUseCase: FetchSinglePokemonUseCase
) : ViewModel() {

    private val _navigationChannel = Channel<PokemonDetailNavigationRequest>()
    val navigationRequest = _navigationChannel.receiveAsFlow()

    private val _uiState = MutableStateFlow(PokemonDetailUiState())
    val uiState = _uiState.asStateFlow()

    fun onUserEvent(event: PokemonDetailUserEvent) {
        when (event) {
            is PokemonDetailUserEvent.OnInitScreen -> handleOnInitScreenEvent(event)
        }
    }

    private fun handleOnInitScreenEvent(event: PokemonDetailUserEvent.OnInitScreen) {
        viewModelScope.launch {

            fetchSinglePokemonUseCase(event.pokemonId)
                .onError {
                    // Todo: Handle Error
                }.onSuccess {
                    _uiState.value = uiState.value.copy(
                        status = UiStatus.Success,
                        pokemon = it
                    )
                }
        }
    }
}