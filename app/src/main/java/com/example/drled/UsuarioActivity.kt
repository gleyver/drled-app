package com.example.drled

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import android.widget.ProgressBar
import android.widget.TextView
import android.widget.Toast
import com.example.drled.R

class UsuarioActivity : AppCompatActivity() {

    private var progressBar: ProgressBar? = null
    private var i = 0
    private var txtView: TextView? = null
    private val handler = Handler()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_usuario)

        val args = intent.extras
        val nomeActionBar = args?.getString("usuario")
        supportActionBar?.title = nomeActionBar
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
