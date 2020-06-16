package br.com.claudiogalvao.catalogofilmes.infrastructure.di

import br.com.claudiogalvao.catalogofilmes.FilmeContract
import br.com.claudiogalvao.catalogofilmes.infrastructure.network.Webservice
import br.com.claudiogalvao.catalogofilmes.model.FilmeModel
import br.com.claudiogalvao.catalogofilmes.presenter.FilmePresenter

object ApplicationModules {
    val filmeModule : FilmeModule by lazy {
        object : FilmeModule{
            override val presenter: FilmeContract.Presenter
                get() = FilmePresenter()

            override val model: FilmeContract.Model
                get() = FilmeModel(Webservice.filmeService())

        }
    }
}