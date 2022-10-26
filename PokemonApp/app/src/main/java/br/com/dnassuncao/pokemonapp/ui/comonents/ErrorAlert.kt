package br.com.dnassuncao.pokemonapp.ui.comonents

import androidx.compose.foundation.layout.Box
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun ErrorAlert(
    message: String,
    modifier: Modifier = Modifier
) {
    Box(modifier = modifier) {
        Text(
            text = message,
            style = MaterialTheme.typography.h3,
            color = MaterialTheme.colors.error,
            modifier = Modifier.align(Alignment.Center)
        )
    }
}

@Preview
@Composable
private fun ErrorMessage_Preview() {
    ErrorAlert("Error loading data")
}
