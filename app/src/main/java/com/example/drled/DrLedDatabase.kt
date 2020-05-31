package com.example.drled

import androidx.room.Database
import androidx.room.RoomDatabase

// anotação define a lista de entidades e a versão do banco
@Database(entities = arrayOf(Produto::class), version = 1)
abstract class DrLedDatabase: RoomDatabase() {
    abstract fun produtoDAO(): ProdutoDAO
}