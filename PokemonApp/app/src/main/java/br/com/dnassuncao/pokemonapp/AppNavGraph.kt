package br.com.dnassuncao.pokemonapp

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import br.com.dnassuncao.pokemonapp.presentation.pokemonNavGraph

fun NavGraphBuilder.appNavGraph(navController: NavHostController) {
    pokemonNavGraph(navController = navController)
}
