package com.example.bibleprojekt.helpers

import android.content.ContentValues
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase

const val TABLE_NAME = "life_file_guides"
const val ID_COL = "id"
const val LIFE_FILE_SECTION_ID = "life_file_section_id"
const val TITLE_COL = "title"
const val STORY_COL = "story"
const val MAIN_VERSE_COL = "main_verse"
const val ASK_YOURSELF_COL = "ask_yourself"
const val CONSIDER_COL = "consider"
const val READ_MORE = "read_more"

data class LifeFileGuideModel(
    var section: String,
    var title: String,
    var story: String,
    var main_verse: String,
    var ask_yourself: String,
    var consider: String,
    var read_more: String,
)

class LifeFileGuide() {
    companion object {
        fun createTableQuery(): String {
            return "CREATE TABLE $TABLE_NAME (" +
                    "$ID_COL INTEGER PRIMARY KEY AUTOINCREMENT" +
                    ",$LIFE_FILE_SECTION_ID INTEGER" +
                    ",$TITLE_COL TEXT" +
                    ",$STORY_COL TEXT" +
                    ",$MAIN_VERSE_COL TEXT" +
                    ",$ASK_YOURSELF_COL TEXT" +
                    ",$CONSIDER_COL TEXT" +
                    ",$READ_MORE TEXT" +
                    ")";
        }

        fun upgradeTableQuery(): String {
            return "DROP TABLE IF EXISTS $TABLE_NAME";
        }

        fun add(
            db: SQLiteDatabase,
            values: ContentValues,
            life_file_section_id: Int,
            title: String,
            story: String,
            main_verse: String,
            ask_yourself: String,
            consider: String,
            read_more: String,
        ) {
            values.put(LIFE_FILE_SECTION_ID, life_file_section_id)
            values.put(TITLE_COL, title)
            values.put(STORY_COL, story)
            values.put(MAIN_VERSE_COL, main_verse)
            values.put(ASK_YOURSELF_COL, ask_yourself)
            values.put(CONSIDER_COL, consider)
            values.put(READ_MORE, read_more)

            db.insert(TABLE_NAME, null, values)
        }

        fun all(
            db: SQLiteDatabase,
        ): ArrayList<LifeFileGuideModel> {
            val recordsCursor: Cursor = db.rawQuery(
                "SELECT * FROM $TABLE_NAME", null
            )

            val recordsArrayList: ArrayList<LifeFileGuideModel> = ArrayList()

            if (recordsCursor.moveToFirst()) {
                do {
                    recordsArrayList.add(
                        LifeFileGuideModel(
                            recordsCursor.getString(1),
                            recordsCursor.getString(2),
                            recordsCursor.getString(3),
                            recordsCursor.getString(4),
                            recordsCursor.getString(5),
                            recordsCursor.getString(6),
                            recordsCursor.getString(7),
                        )
                    )
                } while (recordsCursor.moveToNext())
            }

            recordsCursor.close()
            return recordsArrayList
        }
    }
}

