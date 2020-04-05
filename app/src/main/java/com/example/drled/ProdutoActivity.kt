package com.example.drled

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.SearchView
import android.widget.Toast
import com.example.drled.R

class ProdutoActivity : AppCompatActivity() {

    private val context: Context get() = this
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_produto)

        val args = intent.extras
        val nomeActionBar = args?.getString("produto")
        supportActionBar?.title = nomeActionBar
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        // infla o menu com os botões da ActionBar
        menuInflater.inflate(R.menu.menu, menu)
        (menu?.findItem(R.id.action_buscar)?.actionView as SearchView?)?.setOnQueryTextListener(object : SearchView.OnQueryTextListener {

            override fun onQueryTextChange(newText: String): Boolean {
                // ação enquanto está digitando
                return false
            }

            override fun onQueryTextSubmit(query: String): Boolean {
                // ação  quando terminou de buscar e enviou
                return false
            }

        })
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
        } else if (id == R.id.action_adicionar) {
            var intent = Intent(this, CadastroUsuarioActivity::class.java)
            startActivity(intent)
        } else if (id == R.id.action_config) {
            Toast.makeText(this, "Botão de configuracoes", Toast.LENGTH_LONG).show()
        }
        // botão up navigation
        else if (id == R.id.exit) {
            finish()
        }
        // botão up navigation
        else if (id == android.R.id.home) {
            finish()
        }
        return super.onOptionsItemSelected(item)
    }

}
