package com.example.drled

import android.app.Activity
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.*
import kotlinx.android.synthetic.main.login.*

class MainActivity : DebugActivity() {

    private val context: Context get() = this
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.login)
        // encontra objeto pelo id
        botao_login.setOnClickListener {onClickLogin() }
    }

    fun onClickLogin(){
        val valorUsuario = campo_usuario.text.toString()
        val valorSenha = campo_senha.text.toString()

        if (valorUsuario.equals("aluno") && valorSenha.equals("impacta")) {
            var intent = Intent(this, TelaInicialActivity::class.java)
            startActivity(intent)
        } else {
            Toast.makeText(this, "Usuário ou senha incorretos", Toast.LENGTH_LONG).show()
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if (requestCode == 1) {
            val result = data?.getStringExtra("result")
            Toast.makeText(context, "$result", Toast.LENGTH_LONG).show()
        }
    }

    override fun onResume() {
        super.onResume()
        // abrir a disciplina caso clique na notificação com o aplicativo fechado
        abrirProduto()
        // mostrar no log o tokem do firebase
        Log.d("firebase", "Firebase Token: ${Prefs.getString("FB_TOKEN")}")
    }

    fun abrirProduto() {
        // verificar se existe  id da disciplina na intent
        if (intent.hasExtra("produtoId")) {
            Thread {
                var produtoId = intent.getStringExtra("produtoId")?.toLong()!!
                val produto = ProdutoService.getProduto(this, produtoId)
                runOnUiThread {
                    val intentProduto = Intent(this, ProdutoActivity::class.java)
                    intentProduto.putExtra("produto", produto)
                    startActivity(intentProduto)
                }
            }.start()
        }

    }
}
