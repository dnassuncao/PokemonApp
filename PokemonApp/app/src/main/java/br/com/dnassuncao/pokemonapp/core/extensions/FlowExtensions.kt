package br.com.dnassuncao.pokemonapp.core.extensions

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.FlowCollector
import kotlinx.coroutines.flow.catch

suspend fun <T> Flow<T>.onSuccess(action: suspend (value: T) -> Unit): Unit =
    collect {
        action(it)
    }

fun <T> Flow<T>.onError(action: suspend FlowCollector<T>.(cause: Exception) -> Unit) = catch { e ->
    when (e) {
        is Exception -> action(e)
    }
}