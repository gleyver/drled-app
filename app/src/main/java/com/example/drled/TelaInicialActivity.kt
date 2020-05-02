package com.example.drled

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.core.view.GravityCompat
import com.google.android.material.navigation.NavigationView
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_tela_inicial.*
import kotlinx.android.synthetic.main.toolbar.*

class TelaInicialActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {

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

        configuraMenuLateral()
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

    private fun configuraMenuLateral () {
        var toggle = ActionBarDrawerToggle (
            this,
            layoutMenuLateral,
            toolbar,
            R.string.nav_open,
            R.string.nav_close)
        layoutMenuLateral.addDrawerListener(toggle)
        toggle.syncState()

        menu_lateral.setNavigationItemSelectedListener(this)
    }
    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.nav_fornecedor -> {
                Toast.makeText(this, "Clicou em Fornecedor", Toast.LENGTH_SHORT).show()
            }
            R.id.nav_produto -> {
            Toast.makeText(this, "Clicou em Produto", Toast.LENGTH_SHORT).show()
            }
            R.id.nav_usuario -> {
            Toast.makeText(this, "Clicou em Usuario", Toast.LENGTH_SHORT).show()
        }
        }
        layoutMenuLateral.closeDrawer(GravityCompat.START)
        return true
    }
}
