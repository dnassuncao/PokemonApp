package br.com.dnassuncao.pokemonapp.data.repository

import br.com.dnassuncao.pokemonapp.data.remote.PokemonApi
import br.com.dnassuncao.pokemonapp.domain.model.Pokemon
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class PokemonRepositoryImpl(
    private val pokemonApi: PokemonApi
) : PokemonRepository {
    override suspend fun fetchPokemons(): Flow<List<Pokemon>> = flow {
        emit(
            listOf(
                Pokemon(
                    id = 1,
                    name = "Bulbasaur",
                    image = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/shiny/1.png"
                ),
                Pokemon(
                    id = 2,
                    name = "Charmeleon",
                    image = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/shiny/5.png"
                ),
                Pokemon(
                    id = 3,
                    name = "Pidgey",
                    image = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/shiny/16.png"
                ),
            )
        )
    }
}