package br.com.dnassuncao.pokemonapp.ui.common

sealed class UiStatus {
    object Loading : UiStatus()
    object Success : UiStatus()
    data class Failed(val message: String = "") : UiStatus()
}
