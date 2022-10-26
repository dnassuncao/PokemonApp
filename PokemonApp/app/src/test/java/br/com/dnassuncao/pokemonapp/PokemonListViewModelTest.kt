package br.com.dnassuncao.pokemonapp

import br.com.dnassuncao.pokemonapp.data.entity.PokemonResult
import br.com.dnassuncao.pokemonapp.data.mapper.toDomain
import br.com.dnassuncao.pokemonapp.domain.usecase.FetchListPokemonUseCase
import br.com.dnassuncao.pokemonapp.presentation.pokemonlist.viewmodel.PokemonListUiState
import br.com.dnassuncao.pokemonapp.presentation.pokemonlist.viewmodel.PokemonListUserEvent
import br.com.dnassuncao.pokemonapp.presentation.pokemonlist.viewmodel.PokemonListViewModel
import br.com.dnassuncao.pokemonapp.ui.common.UiStatus
import com.google.common.truth.Truth.assertThat
import io.mockk.MockKAnnotations
import io.mockk.clearAllMocks
import io.mockk.coEvery
import io.mockk.impl.annotations.MockK
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.test.advanceUntilIdle
import kotlinx.coroutines.test.runTest
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class PokemonListViewModelTest {

    @get:Rule
    val mainDispatcherRule = MainDispatcherRule()

    private lateinit var viewModel: PokemonListViewModel

    @MockK
    private lateinit var useCase: FetchListPokemonUseCase

    @Before
    fun setUp() {
        MockKAnnotations.init(this)
        viewModel = PokemonListViewModel(fetchListPokemonUseCase = useCase)
    }

    @After
    fun tearDown() {
        clearAllMocks()
    }

    @Test
    fun `on init screen event, when FetchPokemonUseCase successful should show pokemon list`() = runTest {

        // Given
        val items = listOf(
            PokemonResult(
                name = "Bulbasaur",
                url = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/shiny/1.png"
            ).toDomain(),
            PokemonResult(
                name = "Charmeleon",
                url = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/shiny/5.png"
            ).toDomain(),
            PokemonResult(
                name = "Pidgey",
                url = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/shiny/16.png"
            ).toDomain(),
        )

        coEvery { useCase() } returns flow {
            emit(
                items
            )
        }

        val expectedLoading =
            PokemonListUiState(
                status = UiStatus.Success,
                pokemonList = items
            )

        val expectedSuccess =
            PokemonListUiState(
                status = UiStatus.Success,
                pokemonList = items
            )

        // When
        viewModel.onUserEvent(PokemonListUserEvent.OnInitScreen)

        // Then
        advanceUntilIdle()

        assertThat(viewModel.uiState.first()).isEqualTo(expectedLoading)
        assertThat(viewModel.uiState.first()).isEqualTo(expectedSuccess)
    }
}