package br.com.dnassuncao.pokemonapp.presentation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import br.com.dnassuncao.pokemonapp.presentation.home.HomeRoute

fun NavGraphBuilder.pokemonNavGraph(navController: NavHostController) {
    composable(route = PokemonRoutes.home) {
        HomeRoute(navController = navController)
    }
    composable(route = PokemonRoutes.details) {

    }
}
