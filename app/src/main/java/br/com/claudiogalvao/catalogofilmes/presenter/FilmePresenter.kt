package br.com.claudiogalvao.catalogofilmes.presenter

import br.com.claudiogalvao.catalogofilmes.FilmeContract
import br.com.claudiogalvao.catalogofilmes.infrastructure.network.model.Filme
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import java.lang.Exception

class FilmePresenter : FilmeContract.Presenter {

    private var model: FilmeContract.Model? = null
    private var view: FilmeContract.View? = null

    private val job = Job()
    private val scopeIO = CoroutineScope(job + Dispatchers.IO)
    private val scopeMainThread = CoroutineScope(job + Dispatchers.Main)

    override fun start(view: FilmeContract.View, model: FilmeContract.Model) {
        this.view = view
        this.model = model
        retrieveFilmes()
    }

    override fun destroy() {
        this.view = null
        job.cancel()
    }

    override fun retrieveFilmes() {
        scopeIO.launch {
            model?.getFilmes(this@FilmePresenter)
        }
    }

    override fun finishRetrieveFilmes(filmes: List<Filme>) {
        if(filmes.isEmpty()) {
            scopeMainThread.launch {
                view?.showMessage("Falha ao carregar a lista")
            }
        } else {
            scopeMainThread.launch {
                filmes?.let {
                    view?.showFilmes(it)
                }
            }
        }
    }

}