package br.com.dnassuncao.pokemonapp.data.remote

import androidx.paging.PagingSource
import androidx.paging.PagingState
import br.com.dnassuncao.pokemonapp.data.mapper.toDomain
import br.com.dnassuncao.pokemonapp.data.repository.PokemonRepository
import br.com.dnassuncao.pokemonapp.domain.model.Pokemon

class PokemonDataSource(
    private val repo: PokemonRepository
) : PagingSource<Int, Pokemon>() {

    override fun getRefreshKey(state: PagingState<Int, Pokemon>): Int? {
        return state.anchorPosition?.let { anchorPosition ->
            val anchorPage = state.closestPageToPosition(anchorPosition)
            anchorPage?.prevKey?.plus(1) ?: anchorPage?.nextKey?.minus(1)
        }
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Pokemon> {
        return try {
            val nextPageNumber = params.key ?: 1
            val response = repo.fetchPokemonList(10, nextPageNumber)
            LoadResult.Page(
                data =  response.results.map { pokemonResult -> pokemonResult.toDomain() },
                prevKey = null,
                nextKey = nextPageNumber + 10
            )
        } catch (e: Exception) {
            LoadResult.Error(e)
        }
    }
}