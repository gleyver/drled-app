package com.example.drled


import androidx.room.Room


object DatabaseManager {

    // singleton
    private var dbInstance: DrLedDatabase
    init {
        val appContext = DrLedApplication.getInstance().applicationContext
        dbInstance = Room.databaseBuilder(
            appContext, // contexto global
            DrLedDatabase::class.java, // Referência da classe do banco
            "drled.sqlite" // nome do arquivo do banco
        ).build()
    }

    fun getProdutoDAO(): ProdutoDAO {
        return dbInstance.produtoDAO()
    }
}