package br.com.dnassuncao.pokemonapp.presentation.pokemondetail

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.com.dnassuncao.pokemonapp.R
import br.com.dnassuncao.pokemonapp.domain.model.Pokemon
import br.com.dnassuncao.pokemonapp.presentation.pokemondetail.viewmodel.PokemonDetailUiState
import br.com.dnassuncao.pokemonapp.presentation.pokemondetail.viewmodel.PokemonDetailUserEvent
import br.com.dnassuncao.pokemonapp.ui.common.UiStatus
import br.com.dnassuncao.pokemonapp.ui.comonents.ErrorAlert
import br.com.dnassuncao.pokemonapp.ui.comonents.PokeLoading
import coil.compose.AsyncImage
import coil.request.ImageRequest
import kotlin.math.round

@Composable
fun PokemonDetailScreen(
    uiState: PokemonDetailUiState,
    onUiEvent: (event: PokemonDetailUserEvent) -> Unit
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
                PokemonDetail(
                    pokemon = uiState.pokemon!!,
                    onUiEvent = onUiEvent
                )
            }
        }
    }
}

@Composable
fun PokemonDetail(
    pokemon: Pokemon,
    onUiEvent: (event: PokemonDetailUserEvent) -> Unit
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(bottom = 16.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight(align = Alignment.CenterVertically)
                .padding(10.dp)
        ) {
            AsyncImage(
                model = ImageRequest.Builder(LocalContext.current)
                    .data(pokemon.image)
                    .crossfade(true)
                    .build(),
                error = painterResource(R.drawable.ic_error),
                contentDescription = null,
                modifier = Modifier
                    .size(200.dp)
                    .align(Alignment.CenterHorizontally)
            )

            PokemonDetailSection(
                pokemon = pokemon
            )
        }
    }
}

@Composable
fun PokemonDetailSection(
    pokemon: Pokemon,
    modifier: Modifier = Modifier
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
            .fillMaxSize()
    ) {
        Text(
            text = pokemon.name,
            fontWeight = FontWeight.Bold,
            fontSize = 30.sp,
            textAlign = TextAlign.Center,
            color = MaterialTheme.colors.onSurface
        )
        pokemon.type?.let {
            PokemonTypeSection(type = it)
        }
        PokemonDetailDataSection(
            weight = pokemon.weight!!,
            height = pokemon.height!!
        )
    }
}

@Composable
fun PokemonTypeSection(type: String) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .padding(16.dp)
    ) {
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .weight(1f)
                .padding(horizontal = 8.dp)
                .clip(CircleShape)
                .height(35.dp)
        ) {
            Text(
                text = type,
                fontSize = 18.sp
            )
        }
    }
}

@Composable
fun PokemonDetailDataSection(
    weight: Int,
    height: Int,
    sectionHeight: Dp = 80.dp
) {
    val pokemonWeightInKg = remember {
        round(weight * 100f) / 1000f
    }
    val pokemonHeightInMeters = remember {
        round(height * 100f) / 1000f
    }
    Row(
        modifier = Modifier
            .fillMaxWidth()
    ) {
        PokemonDetailItem(
            value = pokemonWeightInKg,
            unit = "kg",
            icon = painterResource(id = R.drawable.ic_weight),
            modifier = Modifier.weight(1f)
        )
        Spacer(
            modifier = Modifier
                .size(1.dp, sectionHeight)
                .background(Color.LightGray)
        )
        PokemonDetailItem(
            value = pokemonHeightInMeters,
            unit = "m",
            icon = painterResource(id = R.drawable.ic_height),
            modifier = Modifier.weight(1f)
        )
    }
}

@Composable
fun PokemonDetailItem(
    value: Float,
    unit: String,
    icon: Painter,
    modifier: Modifier = Modifier
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = modifier
    ) {
        Icon(painter = icon, contentDescription = null, tint = MaterialTheme.colors.onSurface)
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = "$value$unit",
            color = MaterialTheme.colors.onSurface
        )
    }
}

@Preview
@Composable
fun PokemonDetailScreenPreview() {
    PokemonDetailScreen(
        uiState = PokemonDetailUiState(
            status = UiStatus.Success,
            pokemon = Pokemon(
                name = "Venusaur",
                image = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/shiny/3.png",
                experience = 263,
                weight = null,
                type = "grass, poison"

            )

        ) ,
        onUiEvent = { }
    )
}

