package br.com.dnassuncao.data.repository

import br.com.dnassuncao.data.remote.PokemonApi
import br.com.dnassuncao.domain.model.Pokemon

class PokemonRepositoryImpl(
    private val pokemonApi: PokemonApi
) : PokemonRepository {
    override suspend fun fetchPokemons(): Result<List<Pokemon>> {
        return Result.success(
            value = listOf(
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