package br.com.dnassuncao.pokemonapp.presentation.home.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.dnassuncao.pokemonapp.core.extensions.onError
import br.com.dnassuncao.pokemonapp.core.extensions.onSuccess
import br.com.dnassuncao.pokemonapp.domain.usecase.FetchPokemonUseCase
import br.com.dnassuncao.pokemonapp.ui.common.UiStatus
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch

class HomeViewModel(
    private val fetchPokemonUseCase: FetchPokemonUseCase
) : ViewModel() {

    private val _navigationChannel = Channel<HomeNavigationRequest>()
    val navigationRequest = _navigationChannel.receiveAsFlow()

    private val _uiState = MutableStateFlow(HomeUiState())
    val uiState = _uiState.asStateFlow()

    fun onUserEvent(event: HomeUserEvent) {
        when (event) {
            is HomeUserEvent.OnInitScreen -> handleOnInitScreenEvent()
            is HomeUserEvent.OnItemClick -> handleClickedOnLoginButton(event = event)
        }
    }

    private fun handleClickedOnLoginButton(event: HomeUserEvent.OnItemClick) {

    }

    private fun handleOnInitScreenEvent() {
        viewModelScope.launch {
            _uiState.value = uiState.value.copy(
                status = UiStatus.Loading
            )

            fetchPokemonUseCase()
                .onError {
                    _uiState.value = uiState.value.copy(
                        status = UiStatus.Loading
                    )
                }.onSuccess {
                    _uiState.value = uiState.value.copy(
                        status = UiStatus.Success,
                        pokemonList = it
                    )
                }
        }
    }
}