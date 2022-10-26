package br.com.dnassuncao.pokemonapp

import br.com.dnassuncao.pokemonapp.data.entity.PokemonResponse
import br.com.dnassuncao.pokemonapp.data.mapper.toDomain
import br.com.dnassuncao.pokemonapp.domain.usecase.FetchPokemonUseCase
import br.com.dnassuncao.pokemonapp.presentation.home.viewmodel.HomeUiState
import br.com.dnassuncao.pokemonapp.presentation.home.viewmodel.HomeUserEvent
import br.com.dnassuncao.pokemonapp.presentation.home.viewmodel.HomeViewModel
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

class HomeViewModelTest {

    @get:Rule
    val mainDispatcherRule = MainDispatcherRule()

    private lateinit var viewModel: HomeViewModel

    @MockK
    private lateinit var useCase: FetchPokemonUseCase

    @Before
    fun setUp() {
        MockKAnnotations.init(this)
        viewModel = HomeViewModel(fetchPokemonUseCase = useCase)
    }

    @After
    fun tearDown() {
        clearAllMocks()
    }

    @Test
    fun `on init screen event, when FetchPokemonUseCase successful should show pokemon list`() = runTest {

        // Given
        val items = listOf(
            PokemonResponse(
                id = 1,
                name = "Bulbasaur",
                image = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/shiny/1.png"
            ).toDomain(),
            PokemonResponse(
                id = 2,
                name = "Charmeleon",
                image = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/shiny/5.png"
            ).toDomain(),
            PokemonResponse(
                id = 3,
                name = "Pidgey",
                image = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/shiny/16.png"
            ).toDomain(),
        )

        coEvery { useCase() } returns flow {
            emit(
                items
            )
        }

        val expectedLoading =
            HomeUiState(
                status = UiStatus.Success,
                pokemonList = items
            )

        val expectedSuccess =
            HomeUiState(
                status = UiStatus.Success,
                pokemonList = items
            )

        // When
        viewModel.onUserEvent(HomeUserEvent.OnInitScreen)

        // Then
        advanceUntilIdle()

        assertThat(viewModel.uiState.first()).isEqualTo(expectedLoading)
        assertThat(viewModel.uiState.first()).isEqualTo(expectedSuccess)
    }
}