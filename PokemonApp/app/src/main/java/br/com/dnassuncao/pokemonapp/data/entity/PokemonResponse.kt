package br.com.dnassuncao.pokemonapp.data.entity

import com.google.gson.annotations.SerializedName

data class PokemonResponse(
    @SerializedName("id")
    val id: Int,

    @SerializedName("base_experience")
    val experience: Int,

    @SerializedName("weight")
    val weight: Int,

    @SerializedName("height")
    val height: Int,

    @SerializedName("name")
    val name: String,

    @SerializedName("types")
    val types: List<PokemonTypeResponse>
)

data class PokemonTypeResponse(

    @SerializedName("slot")
    val slot: Int,

    @SerializedName("type")
    val type: PokemonTypeResult
)

data class PokemonTypeResult(

    @SerializedName("name")
    val name: String,

    @SerializedName("url")
    val url: String
)