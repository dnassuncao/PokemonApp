package br.com.dnassuncao.pokemonapp.network.di

import br.com.dnassuncao.pokemonapp.data.remote.PokemonApi
import okhttp3.OkHttpClient
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val networkModule = module {
    factory {
        provideOkHttpClient()
    }
    factory {
        provideForecastApi(get())
    }
    single {
        provideRetrofit(get())
    }

}

fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit {
    return Retrofit.Builder()
        .baseUrl("https://pokeapi.co/api/v2/")
        .client(okHttpClient)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
}

fun provideOkHttpClient(): OkHttpClient {
    return OkHttpClient().newBuilder().build()
}

fun provideForecastApi(retrofit: Retrofit): PokemonApi = retrofit.create(PokemonApi::class.java)