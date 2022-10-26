package br.com.dnassuncao.pokemonapp.data.mapper

import br.com.dnassuncao.pokemonapp.data.entity.PokemonResponse
import br.com.dnassuncao.pokemonapp.data.entity.PokemonResult
import br.com.dnassuncao.pokemonapp.domain.model.Pokemon

fun PokemonResult.toDomain(): Pokemon {
    return Pokemon(
        name = this.name,
        image = this.url.urlToImage()
    )
}

fun PokemonResponse.toDomain(): Pokemon {
    return Pokemon(
        name = this.name,
        image = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/${this.id}.png",
        experience = this.experience,
        weight = this.weight,
        height = this.height,
        type = this.types.joinToString(", ") {
            it.type.name
        },
    )
}

fun String.urlToImage(): String {
    val number = if (this.endsWith("/")) {
        this.dropLast(1).takeLastWhile { it.isDigit() }
    } else {
        this.takeLastWhile { it.isDigit() }
    }

    return "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/${number}.png"
}