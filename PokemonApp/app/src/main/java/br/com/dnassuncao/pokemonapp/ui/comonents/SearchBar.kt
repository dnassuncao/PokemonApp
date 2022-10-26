package br.com.dnassuncao.pokemonapp.ui.comonents

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import br.com.dnassuncao.pokemonapp.R

@Composable
fun SearchBar(
    text: String,
    onChangedSearchText: (String) -> Unit,
    modifier: Modifier = Modifier
) {
    Box(modifier = modifier) {
        OutlinedTextField(
            value = text,
            onValueChange = onChangedSearchText,
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(8.dp),
            colors = TextFieldDefaults.outlinedTextFieldColors(
                focusedBorderColor = MaterialTheme.colors.primary,
                unfocusedBorderColor = if (isSystemInDarkTheme()) Color.DarkGray else Color.LightGray
            ),
            label = { Text(stringResource(R.string.hint_search)) }
        )
    }
}

@Preview
@Composable
fun SearchBar_Preview() {
    SearchBar(
        text = "Pokemon",
        onChangedSearchText = {},
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
    )
}
