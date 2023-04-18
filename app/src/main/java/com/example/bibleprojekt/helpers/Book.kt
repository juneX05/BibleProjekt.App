package com.example.bibleprojekt.helpers

import android.content.ContentValues
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase

data class BookModel(
    var code: String,
    var name: String,
    var abbreviation: String,
    var opener: String,
)

class Book() {
    companion object {
        private const val TABLE_NAME = "books"
        private const val ID_COL = "id"
        private const val CODE_COL = "code"
        private const val NAME_COL = "name"
        private const val ABBREVIATION_COL = "abbreviation"
        private const val OPENER_COL = "opener"

        fun createTableQuery(): String {
            return "CREATE TABLE $TABLE_NAME (" +
                    "$ID_COL INTEGER PRIMARY KEY AUTOINCREMENT" +
                    ",$CODE_COL TEXT NOT NULL" +
                    ",$NAME_COL TEXT NOT NULL" +
                    ",$ABBREVIATION_COL TEXT NOT NULL" +
                    ",$OPENER_COL TEXT" +
                    ")";
        }

        fun upgradeTableQuery(): String {
            return "DROP TABLE IF EXISTS $TABLE_NAME";
        }

        private fun add(
            db: SQLiteDatabase,
            code: String,
            name: String,
            abbreviation: String,
            opener: String? = null,
        ) {
            val values = ContentValues();
            values.put(CODE_COL, code)
            values.put(NAME_COL, name)
            values.put(ABBREVIATION_COL, abbreviation)
            values.put(OPENER_COL, opener)

            db.insert(TABLE_NAME, null, values)
        }

        fun all(
            db: SQLiteDatabase,
        ): ArrayList<BookModel> {
            val recordsCursor: Cursor = db.rawQuery(
                "SELECT * FROM $TABLE_NAME", null
            )

            val recordsArrayList: ArrayList<BookModel> = ArrayList()

            if (recordsCursor.moveToFirst()) {
                do {
                    recordsArrayList.add(
                        BookModel(
                            recordsCursor.getString(1),
                            recordsCursor.getString(2),
                            recordsCursor.getString(3),
                            recordsCursor.getString(3),
                        )
                    )
                } while (recordsCursor.moveToNext())
            }

            recordsCursor.close()
            return recordsArrayList
        }

        fun seed(
            db: SQLiteDatabase
        ) {
            this.add(
                db = db, code = "001", name = "Genesis", abbreviation =  "GEN"
            )
            this.add(
                db = db, code = "002", name = "Exodus", abbreviation =  "EXO"
            )
            this.add(
                db = db, code = "003", name = "Leviticus", abbreviation =  "LEV"
            )
            this.add(
                db = db, code = "004", name = "Numbers", abbreviation =  "NUM"
            )
            this.add(
                db = db, code = "005", name = "Deuteronomy", abbreviation =  "DEUT"
            )
            this.add(
                db = db, code = "006", name = "Deuteronomy", abbreviation =  "DEUT"
            )
            this.add(
                db = db, code = "007", name = "Deuteronomy", abbreviation =  "DEUT"
            )
        }
    }
}

