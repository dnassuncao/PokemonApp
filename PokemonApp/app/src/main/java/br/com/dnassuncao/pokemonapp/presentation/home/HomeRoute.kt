package br.com.dnassuncao.pokemonapp.presentation.home

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.flowWithLifecycle
import androidx.navigation.NavHostController
import br.com.dnassuncao.pokemonapp.presentation.Screen
import br.com.dnassuncao.pokemonapp.presentation.home.viewmodel.HomeNavigationRequest
import br.com.dnassuncao.pokemonapp.presentation.home.viewmodel.HomeUserEvent
import br.com.dnassuncao.pokemonapp.presentation.home.viewmodel.HomeViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import org.koin.androidx.compose.getViewModel

class HomeRoute {
}

@Composable
fun HomeRoute(
    viewModel: HomeViewModel = getViewModel(),
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

        viewModel.onUserEvent(event = HomeUserEvent.OnInitScreen)
    }

    HomeScreen(
        uiState = uiState.value,
        onUiEvent = {}
    )
}

private fun handleNavigationRequestChange(
    request: HomeNavigationRequest,
    navController: NavHostController
) {
    when (request) {
        is HomeNavigationRequest.PokemonDetailScreen -> navController.navigate(Screen.Detail.route)
    }
}