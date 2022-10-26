package br.com.dnassuncao.pokemonapp.presentation

sealed class Screen(val route: String) {
    object Home : Screen(route = PokemonRoutes.home)
    object Detail : Screen(route = PokemonRoutes.details)
}