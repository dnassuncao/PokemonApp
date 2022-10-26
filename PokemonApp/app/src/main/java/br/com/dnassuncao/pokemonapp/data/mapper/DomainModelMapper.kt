package br.com.dnassuncao.pokemonapp.data.mapper

import br.com.dnassuncao.pokemonapp.data.entity.PokemonResponse
import br.com.dnassuncao.pokemonapp.domain.model.Pokemon

fun PokemonResponse.toDomain(): Pokemon {
    return Pokemon(
        id = this.id,
        name = this.name,
        image = this.image
    )
}