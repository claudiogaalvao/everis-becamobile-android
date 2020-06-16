package br.com.claudiogalvao.catalogofilmes.view

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import br.com.claudiogalvao.catalogofilmes.FilmeContract
import br.com.claudiogalvao.catalogofilmes.R
import br.com.claudiogalvao.catalogofilmes.infrastructure.di.ApplicationModules
import br.com.claudiogalvao.catalogofilmes.infrastructure.network.model.Filme
import kotlinx.android.synthetic.main.activity_lista_filmes.*

class ListaFilmesActivity : AppCompatActivity(), FilmeContract.View {
    private val presenter: FilmeContract.Presenter =
        ApplicationModules.filmeModule.presenter
    private val model: FilmeContract.Model =
        ApplicationModules.filmeModule.model

    val onClickListener: OnClickListener = object :
        OnClickListener {
        override fun onClick(filme: Filme) {
            chamaDetalhesFilme(filme)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lista_filmes)
        presenter.start(this, model)
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter.destroy()
    }

    private fun configuraLista(filmes: List<Filme>) {
        val adapter = ListaFilmesAdapter(this, filmes)
        adapter.onClickListener = onClickListener
        activity_lista_filmes_gridview.adapter = adapter
    }

    private fun chamaDetalhesFilme(filme: Filme) {
        var intent = Intent(this@ListaFilmesActivity, DetalhesFilmeActivity::class.java)
        intent.putExtra("filme", filme)
        startActivity(intent)
    }

    override fun showMessage(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show()
    }

    override fun showFilmes(filmes: List<Filme>) {
        configuraLista(filmes)
    }

}
