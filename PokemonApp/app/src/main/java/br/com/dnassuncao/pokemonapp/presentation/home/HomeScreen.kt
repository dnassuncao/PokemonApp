package br.com.dnassuncao.pokemonapp.presentation.home

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import br.com.dnassuncao.pokemonapp.domain.model.Pokemon
import br.com.dnassuncao.pokemonapp.presentation.home.viewmodel.HomeUiState
import br.com.dnassuncao.pokemonapp.presentation.home.viewmodel.HomeUserEvent
import br.com.dnassuncao.pokemonapp.ui.common.UiStatus
import br.com.dnassuncao.pokemonapp.ui.comonents.*

@Composable
fun HomeScreen(
    uiState: HomeUiState,
    onUiEvent: (event: HomeUserEvent) -> Unit
) {

    Surface(color = MaterialTheme.colors.surface) {
        when (val status = uiState.status) {
            UiStatus.Loading -> {
                Loading(
                    modifier = Modifier
                        .fillMaxSize()
                )
            }
            is UiStatus.Failed -> {
                ErrorAlert(
                    message = status.message,
                    modifier = Modifier
                        .fillMaxSize()
                )
            }
            UiStatus.Success -> {
                HomeListScreen(
                    items = uiState.pokemonList,
                    onUiEvent = onUiEvent
                )
            }
        }
    }
}

@Composable
fun HomeListScreen(
    items: List<Pokemon>,
    onUiEvent: (event: HomeUserEvent) -> Unit,
) {
    LazyColumn(
        modifier = Modifier.fillMaxSize(),
    ) {
        item {
            SearchBar(
                text = "",
                onChangedSearchText = {
                    onUiEvent.invoke(HomeUserEvent.OnSearchPokemon(it))
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp)
            )
        }

        items(items, key = { it.id }) { pokemon ->
            Column(Modifier.padding(10.dp)) {
                PokemonCard(
                    name = pokemon.name,
                    picture = pokemon.image,
                    onClick = {
                        onUiEvent.invoke(HomeUserEvent.OnItemClick)
                    },
                )
            }
        }
    }
}
