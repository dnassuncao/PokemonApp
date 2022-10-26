package br.com.dnassuncao.data.entity

import com.google.gson.annotations.SerializedName

data class PokemonResponse(
    @SerializedName("id")
    val id: Long = 0,

    @SerializedName("name")
    val name: String,

    @SerializedName("url")
    val image: String
)