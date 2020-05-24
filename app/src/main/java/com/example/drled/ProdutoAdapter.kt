package com.example.drled

import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import com.squareup.picasso.Picasso

class ProdutoAdapter (
    val produtos: List<Produto>,
    val onClick: (Produto) -> Unit): RecyclerView.Adapter<ProdutoAdapter.ProdutosViewHolder>() {

        // ViewHolder com os elemetos da tela
        class ProdutosViewHolder(view: View): RecyclerView.ViewHolder(view) {
            val cardNome: TextView
            val cardImg : ImageView
            var cardProgress: ProgressBar
            var cardView: CardView

            init {
                cardNome = view.findViewById<TextView>(R.id.cardNome)
                cardImg = view.findViewById<ImageView>(R.id.cardImg)
                cardProgress = view.findViewById<ProgressBar>(R.id.cardProgress)
                cardView = view.findViewById<CardView>(R.id.card_produtos)

            }

        }

        // Quantidade de Produtos na lista

        override fun getItemCount() = this.produtos.size

        // inflar layout do adapter

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProdutosViewHolder {
            // infla view no adapter
            val view = LayoutInflater.from(parent.context).inflate(R.layout.adapter_produto, parent, false)

            // retornar ViewHolder
            val holder = ProdutosViewHolder(view)
            return holder
        }

        // bind para atualizar Views com os dados

        override fun onBindViewHolder(holder: ProdutosViewHolder, position: Int) {
            val context = holder.itemView.context

            // recuperar objeto produto
            val produto = produtos[position]

            // atualizar dados de produto
        }
}