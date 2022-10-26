package br.com.dnassuncao.pokemonapp.ui.comonents

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import br.com.dnassuncao.pokemonapp.R
import com.airbnb.lottie.compose.*

@Composable
fun PokeLoading(modifier: Modifier = Modifier) {
    val composition by rememberLottieComposition(
        LottieCompositionSpec.RawRes(R.raw.pokeball_loading)
    )
    Box(
        modifier = modifier
    ) {
        LottieAnimation(
            composition = composition,
            iterations = LottieConstants.IterateForever,
            modifier = Modifier.size(width = 100.dp, height = 100.dp)
        )
    }
}

@Preview
@Composable
fun LoadingPreview() {
    PokeLoading(modifier = Modifier.fillMaxSize())
}
