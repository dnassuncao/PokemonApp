package br.com.dnassuncao.pokemonapp.presentation.pokemonlist.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.dnassuncao.pokemonapp.core.extensions.onError
import br.com.dnassuncao.pokemonapp.core.extensions.onSuccess
import br.com.dnassuncao.pokemonapp.domain.usecase.FetchListPokemonUseCase
import br.com.dnassuncao.pokemonapp.ui.common.UiStatus
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch

class PokemonListViewModel(
    private val fetchListPokemonUseCase: FetchListPokemonUseCase
) : ViewModel() {

    private val _navigationChannel = Channel<PokemonListNavigationRequest>()
    val navigationRequest = _navigationChannel.receiveAsFlow()

    private val _uiState = MutableStateFlow(PokemonListUiState())
    val uiState = _uiState.asStateFlow()

    fun onUserEvent(event: PokemonListUserEvent) {
        when (event) {
            is PokemonListUserEvent.OnInitScreen -> handleOnInitScreenEvent()
            is PokemonListUserEvent.OnItemClick -> handleClickedOnLoginButton(event = event)
        }
    }

    private fun handleClickedOnLoginButton(event: PokemonListUserEvent.OnItemClick) {
        viewModelScope.launch {
            _navigationChannel.send(
                PokemonListNavigationRequest.PokemonDetailScreen(
                    pokemonId = event.pokemonId,
                )
            )
        }
    }

    private fun handleOnInitScreenEvent() {
        viewModelScope.launch {
            _uiState.value = uiState.value.copy(
                status = UiStatus.Loading
            )

            fetchListPokemonUseCase()
                .onError {
                    // Todo: Handle error
                }.onSuccess {
                    _uiState.value = uiState.value.copy(
                        status = UiStatus.Success,
                        pokemonList = it
                    )
                }
        }
    }
}