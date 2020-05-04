package com.example.drled

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_produto.*
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.toolbar.*

class ProdutoActivity : AppCompatActivity() {

    var produto: Produto? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_produto)

        // recuperar onjeto de Produto da Intent
        produto = intent.getSerializableExtra("produto") as Produto

        // configurar título com nome da Produto e botão de voltar da Toobar
        // colocar toolbar
        setSupportActionBar(toolbar)

        // alterar título da ActionBar
        supportActionBar?.title = produto?.nome

        // up navigation
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        // atualizar dados da produto
        nomeProduto.text = produto?.nome
        Picasso.with(this).load(produto?.foto).fit().into(imagemProduto,
            object: com.squareup.picasso.Callback{
                override fun onSuccess() {}

                override fun onError() { }
            })
    }

}
