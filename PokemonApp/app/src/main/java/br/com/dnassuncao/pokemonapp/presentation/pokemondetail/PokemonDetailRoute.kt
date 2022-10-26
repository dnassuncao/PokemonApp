package br.com.dnassuncao.pokemonapp.presentation.pokemondetail

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.flowWithLifecycle
import androidx.navigation.NavHostController
import br.com.dnassuncao.pokemonapp.presentation.Screen
import br.com.dnassuncao.pokemonapp.presentation.pokemondetail.viewmodel.PokemonDetailNavigationRequest
import br.com.dnassuncao.pokemonapp.presentation.pokemondetail.viewmodel.PokemonDetailUserEvent
import br.com.dnassuncao.pokemonapp.presentation.pokemondetail.viewmodel.PokemonDetailViewModel
import br.com.dnassuncao.pokemonapp.presentation.pokemonlist.viewmodel.PokemonListNavigationRequest
import br.com.dnassuncao.pokemonapp.presentation.pokemonlist.viewmodel.PokemonListUserEvent
import br.com.dnassuncao.pokemonapp.presentation.pokemonlist.viewmodel.PokemonListViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import org.koin.androidx.compose.getViewModel

@Composable
fun PokemonDetailRoute(
    viewModel: PokemonDetailViewModel = getViewModel(),
    pokemonId: String,
    navController: NavHostController
) {
    val lifecycle = LocalLifecycleOwner.current.lifecycle
    val uiState = viewModel.uiState.collectAsState()

    LaunchedEffect(key1 = Unit) {
        viewModel.navigationRequest
            .flowWithLifecycle(lifecycle = lifecycle, Lifecycle.State.STARTED)
            .onEach { request ->
                handleNavigationRequestChange(request, navController)
            }.launchIn(this)

        viewModel.onUserEvent(event = PokemonDetailUserEvent.OnInitScreen(pokemonId))
    }

    PokemonDetailScreen(
        uiState = uiState.value,
        onUiEvent = {}
    )
}

private fun handleNavigationRequestChange(
    request: PokemonDetailNavigationRequest,
    navController: NavHostController
) {
    when (request) {
        is PokemonDetailNavigationRequest.PokemonDetailBack -> navController.navigate(Screen.Detail.route)
    }
}