package br.com.claudiogalvao.catalogofilmes.infrastructure.network

import br.com.claudiogalvao.catalogofilmes.infrastructure.network.model.ApiResponse
import retrofit2.Call
import retrofit2.http.GET

interface Api {

    @GET("trending/movie/week?api_key=696a8a555845ed882929281feba3dabf&page=1&language=pt-BR")
    fun fetchTrendingMovies() : Call<ApiResponse>

}