package com.example.drled

import android.content.Context
import android.provider.CalendarContract
import android.util.Log
import android.widget.Toast
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import org.json.JSONArray
import java.net.URL


object ProdutoService {

    //TROQUE PELA URL DE ONDE ESTÁ O WS
    // Veja um exemplo no repositório https://github.com/fesousa/aula-android-kotlin-api
    val host = "https://gleyver10.pythonanywhere.com"
    val TAG = "WS_DrLed"

    fun getProdutos (context: Context): List<Produto> {
        var produtos = ArrayList<Produto>()
        if (AndroidUtils.isInternetDisponivel()) {
            val url = "$host/produtos"
            val json = HttpHelper.get(url)
            produtos = parserJson(json)
            // salvar offline
            for (d in produtos) {
                saveOffline(d)
            }
            return produtos
        } else {
            val dao = DatabaseManager.getProdutoDAO()
            val produtos = dao.findAll()
            return produtos
        }

    }

    fun getProduto (context: Context, id: Long): Produto? {

        if (AndroidUtils.isInternetDisponivel()) {
            val url = "$host/produtos/${id}"
            val json = HttpHelper.get(url)
            val produto = parserJson<Produto>(json)

            return produto
        } else {
            val dao = DatabaseManager.getProdutoDAO()
            val produto = dao.getById(id)
            return produto
        }

    }

    fun save(produto: Produto): Response {
        if (AndroidUtils.isInternetDisponivel()) {
            val json = HttpHelper.post("$host/produtos", produto.toJson())
            return parserJson(json)
        }
        else {
            saveOffline(produto)
            return Response("OK", "Produto salva no dispositivo")
        }
    }

    fun saveOffline(produto: Produto) : Boolean {
        val dao = DatabaseManager.getProdutoDAO()

        if (! existeProduto(produto)) {
            dao.insert(produto)
        }

        return true

    }

    fun existeProduto(produto: Produto): Boolean {
        val dao = DatabaseManager.getProdutoDAO()
        return dao.getById(produto.id) != null
    }

    fun delete(produto: Produto): Response {
        if (AndroidUtils.isInternetDisponivel()) {
            val url = "$host/produtos/${produto.id}"
            val json = HttpHelper.delete(url)

            return parserJson(json)
        } else {
            val dao = DatabaseManager.getProdutoDAO()
            dao.delete(produto)
            return Response(status = "OK", msg = "Dados salvos localmente")
        }

    }

    inline fun <reified T> parserJson(json: String): T {
        val type = object : TypeToken<T>(){}.type
        return Gson().fromJson<T>(json, type)
    }
}