package br.com.claudiogalvao.catalogofilmes

import br.com.claudiogalvao.catalogofilmes.infrastructure.network.model.Filme
import br.com.claudiogalvao.catalogofilmes.presenter.FilmePresenter

interface FilmeContract {

    interface Model {
        suspend fun getFilmes(coroutineScope: FilmePresenter)
    }

    interface Presenter {
        fun start(view: View, model: Model)
        fun destroy()
        fun retrieveFilmes()
        fun finishRetrieveFilmes(filmes: List<Filme>)
    }

    interface View {
        fun showMessage(message: String)
        fun showFilmes(filmes: List<Filme>)
    }

}