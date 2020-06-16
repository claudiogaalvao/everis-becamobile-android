package br.com.claudiogalvao.catalogofilmes.infrastructure.network.model

import br.com.claudiogalvao.catalogofilmes.infrastructure.network.model.Filme

class ApiResponse(val page: Int,
                  val total_results: Int,
                  val total_pages: Int,
                  val results: ArrayList<Filme>)