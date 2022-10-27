package br.com.dnassuncao.pokemonapp.presentation.pokemonlist

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.Arrangement.Absolute.Center
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.paging.LoadState
import androidx.paging.PagingData
import androidx.paging.compose.collectAsLazyPagingItems
import androidx.paging.compose.items
import br.com.dnassuncao.pokemonapp.domain.model.Pokemon
import br.com.dnassuncao.pokemonapp.presentation.pokemonlist.viewmodel.PokemonListUiState
import br.com.dnassuncao.pokemonapp.presentation.pokemonlist.viewmodel.PokemonListUserEvent
import br.com.dnassuncao.pokemonapp.ui.common.UiStatus
import br.com.dnassuncao.pokemonapp.ui.comonents.ErrorAlert
import br.com.dnassuncao.pokemonapp.ui.comonents.PokeLoading
import br.com.dnassuncao.pokemonapp.ui.comonents.PokemonCard
import br.com.dnassuncao.pokemonapp.ui.comonents.SearchBar
import kotlinx.coroutines.flow.Flow

@Composable
fun PokemonListScreen(
    pokemonPager: Flow<PagingData<Pokemon>>,
    onUiEvent: (event: PokemonListUserEvent) -> Unit
) {
    Surface(
        color = MaterialTheme.colors.background,
        modifier = Modifier.fillMaxSize()
    ) {
        val usersList = pokemonPager.collectAsLazyPagingItems()

        LazyColumn(modifier = Modifier.fillMaxSize()) {
            items(usersList) { item ->
                item?.let {
                    Column(Modifier.padding(10.dp)) {
                        PokemonCard(
                            name = it.name,
                            picture = it.image,
                            onClick = {
                                onUiEvent.invoke(PokemonListUserEvent.OnItemClick(pokemonId = it.name))
                            },
                        )
                    }
                }
            }

            when (usersList.loadState.append) {
                is LoadState.NotLoading -> Unit
                LoadState.Loading -> {
                    item {
                        Box(
                            modifier = Modifier.fillMaxSize(),
                            contentAlignment = Alignment.Center
                        ) {
                            PokeLoading(
                                modifier = Modifier
                                    .wrapContentSize()
                            )
                        }
                    }
                }
                is LoadState.Error -> {
                    item {
                        ErrorAlert(
                            message = "Error to load data",
                            modifier = Modifier.fillMaxSize()
                        )
                    }
                }
            }

            when (usersList.loadState.refresh) {
                is LoadState.NotLoading -> Unit
                LoadState.Loading -> {
                    item {
                        Box(
                            modifier = Modifier.fillMaxSize(),
                            contentAlignment = Alignment.Center
                        ) {
                            PokeLoading(
                                modifier = Modifier.wrapContentSize()
                                    .size(width = 100.dp, height = 100.dp)
                            )
                        }
                    }
                }
                is LoadState.Error -> {
                    item {
                        Box(
                            modifier = Modifier.fillMaxWidth(),
                            contentAlignment = Alignment.Center
                        ) {
                            ErrorAlert(
                                message = "Error to load data",
                                modifier = Modifier.fillMaxSize()
                            )
                        }
                    }

                }
            }
        }
    }
}