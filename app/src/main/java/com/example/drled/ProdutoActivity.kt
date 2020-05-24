package com.example.drled

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import kotlinx.android.synthetic.main.activity_produto.*
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_tela_inicial.*
import kotlinx.android.synthetic.main.toolbar.*

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ProdutoActivity : AppCompatActivity() {

    var produto: Produto? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_produto)

        getData()
    }


    fun getData() {
        val retrofitClient = NetworkUtils
            .getRetrofitInstance("https://jsonplaceholder.typicode.com")

        val endpoint = retrofitClient.create(ProdutoService::class.java)
        val callback = endpoint.getProdutos()

        callback.enqueue(object : Callback<List<Produto>> {
            override fun onFailure(call: Call<List<Produto>>, t: Throwable) {
                Toast.makeText(baseContext, t.message, Toast.LENGTH_SHORT).show()
            }

            override fun onResponse(call: Call<List<Produto>>, response: Response<List<Produto>>) {
                response.body()?.forEach {
                    nomeProduto.text = nomeProduto.text.toString().plus(it.body)
                }
            }
        })

    }
}
