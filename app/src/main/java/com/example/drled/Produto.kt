package com.example.drled

import java.io.Serializable

class Produto : Serializable {
    var id:Long = 0
    var nome:String = ""
    var foto:String = ""

    override fun toString(): String {
        return "Produto(nome='$nome')"
    }
}