package com.example.bibleprojekt.helpers

import android.content.ContentValues
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase

data class LifeFileSectionModel(
    var name: String,
)

class LifeFileSection() {
    companion object {
        private const val TABLE_NAME = "life_file_sections"
        private const val ID_COL = "id"
        private const val NAME_COL = "name"

        fun createTableQuery(): String {
            return "CREATE TABLE $TABLE_NAME (" +
                    "$ID_COL INTEGER PRIMARY KEY AUTOINCREMENT" +
                    ",$NAME_COL TEXT" +
                    ")";
        }

        fun upgradeTableQuery(): String {
            return "DROP TABLE IF EXISTS $TABLE_NAME";
        }

        fun add(
            db: SQLiteDatabase,
            values: ContentValues,
            name: String,
        ) {
            values.put(NAME_COL, name)

            db.insert(TABLE_NAME, null, values)
        }

        fun all(
            db: SQLiteDatabase,
        ): ArrayList<LifeFileSectionModel> {
            val recordsCursor: Cursor = db.rawQuery(
                "SELECT * FROM $TABLE_NAME", null
            )

            val recordsArrayList: ArrayList<LifeFileSectionModel> = ArrayList()

            if (recordsCursor.moveToFirst()) {
                do {
                    recordsArrayList.add(
                        LifeFileSectionModel(
                            recordsCursor.getString(1),
                        )
                    )
                } while (recordsCursor.moveToNext())
            }

            recordsCursor.close()
            return recordsArrayList
        }
    }
}

