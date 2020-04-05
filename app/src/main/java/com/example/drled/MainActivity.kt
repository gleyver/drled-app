package com.example.drled

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.login.*

class MainActivity : AppCompatActivity() {

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
}
