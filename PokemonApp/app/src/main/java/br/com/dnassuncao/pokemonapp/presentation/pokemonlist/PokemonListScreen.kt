package br.com.dnassuncao.pokemonapp.presentation.pokemonlist

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import br.com.dnassuncao.pokemonapp.domain.model.Pokemon
import br.com.dnassuncao.pokemonapp.presentation.pokemonlist.viewmodel.PokemonListUiState
import br.com.dnassuncao.pokemonapp.presentation.pokemonlist.viewmodel.PokemonListUserEvent
import br.com.dnassuncao.pokemonapp.ui.common.UiStatus
import br.com.dnassuncao.pokemonapp.ui.comonents.ErrorAlert
import br.com.dnassuncao.pokemonapp.ui.comonents.PokeLoading
import br.com.dnassuncao.pokemonapp.ui.comonents.PokemonCard
import br.com.dnassuncao.pokemonapp.ui.comonents.SearchBar

@Composable
fun PokemonListScreen(
    uiState: PokemonListUiState,
    onUiEvent: (event: PokemonListUserEvent) -> Unit
) {
    Surface(
        color = MaterialTheme.colors.background,
        modifier = Modifier.fillMaxSize()
    ) {
        when (val status = uiState.status) {
            UiStatus.Loading -> {
                Box(
                    modifier = Modifier.fillMaxWidth(),
                    contentAlignment = Alignment.Center
                ) {
                    PokeLoading(
                        modifier = Modifier.wrapContentSize()
                    )
                }
            }
            is UiStatus.Failed -> {
                ErrorAlert(
                    message = status.message,
                    modifier = Modifier.fillMaxSize()
                )
            }
            UiStatus.Success -> {
                PokemonList(
                    items = uiState.pokemonList,
                    onUiEvent = onUiEvent
                )
            }
        }
    }
}

@Composable
fun PokemonList(
    items: List<Pokemon>,
    onUiEvent: (event: PokemonListUserEvent) -> Unit,
) {
    LazyColumn(
        modifier = Modifier.fillMaxSize(),
    ) {
        item {
            SearchBar(
                text = "",
                onChangedSearchText = {
                    onUiEvent.invoke(PokemonListUserEvent.OnSearchPokemon(it))
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp)
            )
        }

        items(items, key = { it.name }) { pokemon ->
            Column(Modifier.padding(10.dp)) {
                PokemonCard(
                    name = pokemon.name,
                    picture = pokemon.image,
                    onClick = {
                        onUiEvent.invoke(PokemonListUserEvent.OnItemClick(pokemonId = pokemon.name))
                    },
                )
            }
        }
    }
}
