package com.example.drled

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class TelaInicialActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn_fonecedor.setOnClickListener {
            var intent = Intent(this, FornecedorActivity::class.java)
            intent.putExtra("fornecedor", "Fornecedor")
            startActivity(intent)
        }

        btn_produto.setOnClickListener {
            var intent = Intent(this, ProdutoActivity::class.java)
            intent.putExtra("produto", "Produto")
            startActivity(intent)
        }

        btn_usuario.setOnClickListener {
            var intent = Intent(this, UsuarioActivity::class.java)
            intent.putExtra("usuario", "Usuario")
            startActivity(intent)
        }

        supportActionBar?.title = "Home"
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        // infla o menu com os botões da ActionBar
        menuInflater.inflate(R.menu.menu, menu)
        return true;
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        // id do item clicado
        val id = item?.itemId
        // verificar qual item foi clicado e mostrar a mensagem Toast na tela
        // a comparação é feita com o recurso de id definido no xml
        if  (id == R.id.action_buscar) {
            Toast.makeText(this, "Botão de buscar", Toast.LENGTH_LONG).show()
        } else if (id == R.id.action_atualizar) {
            Toast.makeText(this, "Botão de atualizar", Toast.LENGTH_LONG).show()
        } else if (id == R.id.action_config) {
            Toast.makeText(this, "Botão de configuracoes", Toast.LENGTH_LONG).show()
        }
        // botão up navigation
        else if (id == R.id.exit) {
            var intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
        return super.onOptionsItemSelected(item)
    }
}
