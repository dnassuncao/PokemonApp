package br.com.dnassuncao.pokemonapp.presentation.pokemonlist.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.cachedIn
import br.com.dnassuncao.pokemonapp.data.remote.PokemonDataSource
import br.com.dnassuncao.pokemonapp.data.repository.PokemonRepository
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch

class PokemonListViewModel(
    private val pokemonRepository: PokemonRepository
) : ViewModel() {

    private val _navigationChannel = Channel<PokemonListNavigationRequest>()
    val navigationRequest = _navigationChannel.receiveAsFlow()

    private val _uiState = MutableStateFlow(PokemonListUiState())
    val uiState = _uiState.asStateFlow()

    val pokemonPager = Pager(
        PagingConfig(pageSize = 10)
    ) {
        PokemonDataSource(pokemonRepository)
    }.flow.cachedIn(viewModelScope)

    fun onUserEvent(event: PokemonListUserEvent) {
        when (event) {
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

}