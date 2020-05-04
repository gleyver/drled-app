package com.example.drled

import android.content.Context

object ProdutoService {
    fun getProduto (context: Context): List<Produto> {
        val produtos = mutableListOf<Produto>()

        // criar 10 produtos
        for (i in 1..10) {
            val d = Produto()
            d.nome = "Produto $i"
            d.foto = "https://cdn.pixabay.com/photo/2018/01/18/20/42/pencil-3091204_1280.jpg"
            produtos.add(d)
        }

        return produtos
    }

}