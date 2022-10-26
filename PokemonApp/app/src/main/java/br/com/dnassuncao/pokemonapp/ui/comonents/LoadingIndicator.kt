package br.com.dnassuncao.pokemonapp.ui.comonents

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun Loading(modifier: Modifier = Modifier) {
    Box(
        modifier = modifier
    ) {
        CircularProgressIndicator(
            modifier = Modifier.align(Alignment.Center)
        )
    }
}

@Preview
@Composable
fun LoadingPreview() {
    Loading(modifier = Modifier.fillMaxSize())
}
