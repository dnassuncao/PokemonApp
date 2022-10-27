package br.com.dnassuncao.pokemonapp

import br.com.dnassuncao.pokemonapp.data.repository.PokemonRepository
import br.com.dnassuncao.pokemonapp.presentation.pokemonlist.viewmodel.PokemonListViewModel
import io.mockk.MockKAnnotations
import io.mockk.clearAllMocks
import io.mockk.impl.annotations.MockK
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
    private lateinit var repository: PokemonRepository

    @Before
    fun setUp() {
        MockKAnnotations.init(this)
        viewModel = PokemonListViewModel(pokemonRepository = repository)
    }

    @After
    fun tearDown() {
        clearAllMocks()
    }

    @Test
    fun `on init screen event, when FetchPokemonUseCase successful should show pokemon list`() = runTest {

//        // Given
//        val items = listOf(
//            PokemonResult(
//                name = "Bulbasaur",
//                url = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/shiny/1.png"
//            ).toDomain(),
//            PokemonResult(
//                name = "Charmeleon",
//                url = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/shiny/5.png"
//            ).toDomain(),
//            PokemonResult(
//                name = "Pidgey",
//                url = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/shiny/16.png"
//            ).toDomain(),
//        )
//
//        coEvery { useCase() } returns flow {
//            emit(
//                items
//            )
//        }
//
//        val expectedLoading =
//            PokemonListUiState(
//                status = UiStatus.Success,
//                pokemonList = items
//            )
//
//        val expectedSuccess =
//            PokemonListUiState(
//                status = UiStatus.Success,
//                pokemonList = items
//            )
//
//        // When
//        viewModel.onUserEvent(PokemonListUserEvent.OnInitScreen)
//
//        // Then
//        advanceUntilIdle()
//
//        assertThat(viewModel.uiState.first()).isEqualTo(expectedLoading)
//        assertThat(viewModel.uiState.first()).isEqualTo(expectedSuccess)
    }
}