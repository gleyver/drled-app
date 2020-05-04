package com.example.drled

import android.content.Context

object ProdutoService {
    fun getProduto (context: Context): List<Produto> {
        val produtos = mutableListOf<Produto>()

        // criar 10 produtos
        for (i in 1..10) {
            val d = Produto()
            d.nome = "Produto $i"
            d.foto = "https://cdn.pixabay.com/photo/2016/11/18/12/01/white-male-1834084_960_720.jpg"
            produtos.add(d)
        }

        return produtos
    }

}