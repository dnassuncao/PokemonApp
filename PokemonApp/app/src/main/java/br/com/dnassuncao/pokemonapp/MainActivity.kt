package br.com.dnassuncao.pokemonapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import br.com.dnassuncao.pokemonapp.presentation.PokemonRoutes
import br.com.dnassuncao.pokemonapp.ui.theme.PokemonAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()

            PokemonAppTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    NavHost(
                        navController = navController,
                        startDestination = PokemonRoutes.home
                    ) {
                        appNavGraph(navController = navController)
                    }
                }
            }
        }
    }
}