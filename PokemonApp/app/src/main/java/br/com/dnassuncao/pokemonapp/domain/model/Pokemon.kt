package br.com.dnassuncao.pokemonapp.domain.model

data class Pokemon(
    val name: String,
    val image: String,
    val experience: Int? = 0,
    val weight: Int? = 0,
    val height: Int? = 0,
    val type: String? = ""
)