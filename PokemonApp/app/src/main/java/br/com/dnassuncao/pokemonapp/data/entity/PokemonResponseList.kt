package br.com.dnassuncao.pokemonapp.data.entity

import com.google.gson.annotations.SerializedName

data class PokemonResponseList(
    @SerializedName("count")
    val count: Long,

    @SerializedName("next")
    val next: String,

    @SerializedName("results")
    val results: List<PokemonResult>
)

data class PokemonResult(

    @SerializedName("name")
    val name: String,

    @SerializedName("url")
    val url: String
)