package br.com.dnassuncao.pokemonapp.ui.comonents

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import br.com.dnassuncao.pokemonapp.R

@Composable
fun AppToolbar(
    onBackButtonClick: (() -> Unit)? = null,
    onCloseButtonClick: (() -> Unit)? = null
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(50.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        val isBackButtonVisible = if (onBackButtonClick != null) 1f else 0f
        Image(
            painter = painterResource(id = R.drawable.ic_back_arrow),
            contentDescription = null,
            modifier = Modifier
                .alpha(isBackButtonVisible)
                .padding(start = 15.dp)
                .width(50.dp)
                .fillMaxHeight()
                .clickable {
                    onBackButtonClick?.invoke()
                },
            contentScale = ContentScale.Inside,
        )

        val isCloseButtonVisible = if (onCloseButtonClick != null) 1f else 0f
        Image(
            painter = painterResource(id = R.drawable.ic_close),
            contentDescription = null,
            modifier = Modifier
                .alpha(isCloseButtonVisible)
                .padding(end = 30.dp)
                .width(50.dp)
                .fillMaxHeight()
                .clickable {
                    onCloseButtonClick?.invoke()
                },
            contentScale = ContentScale.Inside,
        )
    }
}

@Preview
@Composable
private fun TopBarPreview() {
    AppToolbar(
        onCloseButtonClick = { },
        onBackButtonClick = { }
    )
}
