package br.com.dnassuncao.pokemonapp.domain.model

sealed class Result<T> {

    data class Successful<T>(val data: T) : Result<T>()

    sealed class Failure<T> : Result<T>() {

        sealed class Network<T> : Failure<T>() {

            class NoInternetConnection<T> : Network<T>()

            class Timeout<T> : Network<T>()

            data class ClientError<T>(val code: Int, val message: String?) : Network<T>()

            data class ServerError<T>(val code: Int, val message: String?) : Network<T>()
        }
    }
}
