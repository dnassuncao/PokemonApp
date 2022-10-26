package br.com.dnassuncao.pokemonapp.presentation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import br.com.dnassuncao.pokemonapp.presentation.pokemondetail.PokemonDetailRoute
import br.com.dnassuncao.pokemonapp.presentation.pokemonlist.PokemonListRoute

fun NavGraphBuilder.pokemonNavGraph(navController: NavHostController) {
    composable(route = PokemonRoutes.home) {
        PokemonListRoute(navController = navController)
    }
    composable(route = PokemonRoutes.details) {
        PokemonDetailRoute(
            navController = navController,
            pokemonId = it.arguments?.getString("pokemonId")!!
        )
    }
}
