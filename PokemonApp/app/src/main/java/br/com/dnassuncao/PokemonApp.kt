package br.com.dnassuncao

import android.app.Application
import br.com.dnassuncao.pokemonapp.BuildConfig
import br.com.dnassuncao.di.AppModules
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

class PokemonApp : Application() {

    override fun onCreate() {
        super.onCreate()
        setupKoin()
    }

    private fun setupKoin() {
        startKoin {
            androidLogger(if (BuildConfig.DEBUG) Level.ERROR else Level.NONE)
            androidContext(androidContext = this@PokemonApp)
            modules(
                *AppModules.modules.toTypedArray(),
            )
        }
    }
}