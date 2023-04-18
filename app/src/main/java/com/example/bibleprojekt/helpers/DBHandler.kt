package com.example.bibleprojekt.helpers

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.util.Log
import androidx.compose.runtime.Composable
import com.example.bibleprojekt.R
import java.io.InputStream

class DBHandler (context: Context) :
    SQLiteOpenHelper(context, DB_NAME, null, DB_VERSION) {

    init {
        val queriesStream: InputStream = context.resources.openRawResource(R.raw.database_init)
        QUERIES = queriesStream.bufferedReader().readText().split(";")
    }

    companion object {
        private const val DB_NAME = "bibleprojekt_db.sqlite"

        private const val DB_VERSION = 1

        private lateinit var QUERIES: List<String>
    }

    override fun onCreate(db: SQLiteDatabase) {

        Log.d("QUERIES", QUERIES.joinToString("|"))

        QUERIES.forEach { query ->
            if (query.isNotEmpty()){
                Log.d("Query", query)
                db.execSQL(query)
            }
        }

//        db.execSQL(Book.createTableQuery())
        db.execSQL(LifeFileSection.createTableQuery())
        db.execSQL(LifeFileGuide.createTableQuery())
//
//        seedDB(db)
    }

    private fun seedDB(db: SQLiteDatabase) {
        Book.seed(db)
    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        db.execSQL(Book.upgradeTableQuery())
        db.execSQL(LifeFileSection.upgradeTableQuery())
        db.execSQL(LifeFileGuide.upgradeTableQuery())

        onCreate(db)
    }
}