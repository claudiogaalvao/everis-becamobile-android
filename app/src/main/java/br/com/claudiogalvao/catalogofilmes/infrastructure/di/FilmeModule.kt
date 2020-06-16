package br.com.claudiogalvao.catalogofilmes.infrastructure.di

import br.com.claudiogalvao.catalogofilmes.FilmeContract

interface FilmeModule {
    val presenter : FilmeContract.Presenter
    val model : FilmeContract.Model
}