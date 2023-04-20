package com.example.bibleprojekt.helpers

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.webkit.JsPromptResult
import androidx.compose.ui.platform.LocalContext
import com.example.bibleprojekt.R
import com.squareup.moshi.JsonReader
import com.squareup.moshi.Moshi
import okio.BufferedSource
import okio.buffer
import okio.source
import java.io.InputStream
import java.io.InputStreamReader

const val TABLE_NAME = "life_file_guides"
const val ID_COL = "id"
const val LIFE_FILE_SECTION_ID = "life_file_section_id"
const val TITLE_COL = "title"
const val STORY_COL = "story"
const val MAIN_VERSE_COL = "main_verse"
const val ASK_YOURSELF_COL = "ask_yourself"
const val CONSIDER_COL = "consider"
const val READ_MORE = "read_more"

data class Section(
    val title: String,
    var stories: List<Story>,
)

data class Story(
    val story: String,
    val title: String,
    val subtitle: String
)

class LifeFileGuide() {
    companion object {

        fun all(
            context: Context
        ): MutableList<Section> {
            val moshi = Moshi.Builder().build()

            val inputStream: BufferedSource = context.assets.open("life_file_guides.json").source().buffer()
            val jsonReader = JsonReader.of(inputStream)

            jsonReader.beginArray()

            val sections = mutableListOf<Section>()

            while (jsonReader.hasNext()) {
                var sectionTitle = "";
                val stories = mutableListOf<Story>()

                jsonReader.beginObject()

                while (jsonReader.hasNext()) {
                    val key = jsonReader.nextName()

                    when(key) {
                        "title" -> sectionTitle = jsonReader.nextString()
                        "stories" -> {
                            jsonReader.beginArray()

                            while (jsonReader.hasNext()) {
                                jsonReader.beginObject()

                                var storyText: String = ""
                                var storyTitle: String = ""
                                var storySubtitle: String = ""

                                while (jsonReader.hasNext()) {
                                    val storyKey = jsonReader.nextName()

                                    when(storyKey) {
                                        "story" -> storyText = jsonReader.nextString()
                                        "title" -> storyTitle = jsonReader.nextString()
                                        "subtitle" -> storySubtitle = jsonReader.nextString()
                                        else -> jsonReader.skipValue()
                                    }
                                }

                                stories.add(Story(
                                    storyText, storyTitle, storySubtitle
                                ))

                                jsonReader.endObject()
                            }

                            jsonReader.endArray()
                        }

                        else -> jsonReader.skipValue()
                    }
                }

                sections.add(
                    Section(
                        sectionTitle,
                        stories
                    )
                )

                jsonReader.endObject()
            }

            jsonReader.endArray()
            jsonReader.close()

            return sections
        }
    }
}

