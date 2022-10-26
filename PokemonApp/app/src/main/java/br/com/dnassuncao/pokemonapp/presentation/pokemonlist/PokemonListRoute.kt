package br.com.dnassuncao.pokemonapp.presentation.pokemonlist

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.flowWithLifecycle
import androidx.navigation.NavHostController
import br.com.dnassuncao.pokemonapp.presentation.Screen
import br.com.dnassuncao.pokemonapp.presentation.pokemonlist.viewmodel.PokemonListNavigationRequest
import br.com.dnassuncao.pokemonapp.presentation.pokemonlist.viewmodel.PokemonListUserEvent
import br.com.dnassuncao.pokemonapp.presentation.pokemonlist.viewmodel.PokemonListViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import org.koin.androidx.compose.getViewModel

@Composable
fun PokemonListRoute(
    viewModel: PokemonListViewModel = getViewModel(),
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

        viewModel.onUserEvent(event = PokemonListUserEvent.OnInitScreen)
    }

    PokemonListScreen(
        uiState = uiState.value,
        onUiEvent = {
            viewModel.onUserEvent(event = it)
        }
    )
}

private fun handleNavigationRequestChange(
    request: PokemonListNavigationRequest,
    navController: NavHostController
) {
    when (request) {
        is PokemonListNavigationRequest.PokemonDetailScreen -> navController.navigate(
            Screen.Detail.route.replace("{pokemonId}", request.pokemonId)
        )
    }
}