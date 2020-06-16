package br.com.claudiogalvao.catalogofilmes.model

import br.com.claudiogalvao.catalogofilmes.FilmeContract
import br.com.claudiogalvao.catalogofilmes.infrastructure.network.Api
import br.com.claudiogalvao.catalogofilmes.infrastructure.network.Webservice
import br.com.claudiogalvao.catalogofilmes.infrastructure.network.model.ApiResponse
import br.com.claudiogalvao.catalogofilmes.presenter.FilmePresenter
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class FilmeModel(private val api: Api) : FilmeContract.Model {

    override suspend fun getFilmes(presenter: FilmePresenter) {
        val call = Webservice.filmeService().fetchTrendingMovies()

        call.enqueue(object : Callback<ApiResponse> {
            override fun onFailure(call: Call<ApiResponse>, t: Throwable) {
                presenter.finishRetrieveFilmes(listOf())
            }

            override fun onResponse(call: Call<ApiResponse>, response: Response<ApiResponse>) {
                presenter.finishRetrieveFilmes(response.body()!!.results)
            }

        })
    }

}