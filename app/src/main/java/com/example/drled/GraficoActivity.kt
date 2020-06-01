package com.example.drled

import android.content.Intent
import android.os.Bundle
import android.os.PersistableBundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_grafico.*

class GraficoActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_grafico)

        btn_grafico_pizza.setOnClickListener {
            var intent = Intent(this, GraficoPizzaActivity::class.java)
            startActivity(intent)
        }

        btn_grafico_torta.setOnClickListener {
            var intent = Intent(this, GraficoTortaActivity::class.java)
            startActivity(intent)
        }
    }
}