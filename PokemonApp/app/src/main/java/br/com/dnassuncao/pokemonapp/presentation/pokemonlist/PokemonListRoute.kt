package br.com.dnassuncao.pokemonapp.presentation.pokemonlist

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.flowWithLifecycle
import androidx.navigation.NavHostController
import br.com.dnassuncao.pokemonapp.presentation.Screen
import br.com.dnassuncao.pokemonapp.presentation.pokemonlist.viewmodel.PokemonListNavigationRequest
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

    LaunchedEffect(key1 = Unit) {
        viewModel.navigationRequest
            .flowWithLifecycle(lifecycle = lifecycle, Lifecycle.State.STARTED)
            .onEach { request ->
                handleNavigationRequestChange(request, navController)
            }.launchIn(this)
    }

    PokemonListScreen(
        pokemonPager = viewModel.pokemonPager,
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