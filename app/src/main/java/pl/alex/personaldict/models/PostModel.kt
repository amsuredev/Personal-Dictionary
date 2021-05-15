package pl.alex.personaldict.models

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.widget.Toast
import pl.alex.personaldict.PersonalJournalDbHelper

class PostModel(id: Int, date: String, place: String, smallImage: String, bigImage: String, isLiked: Boolean, description: String, context: Context){
    val id = id
    val date = date
    val place = place
    val smallImage = smallImage
    val bigImage = bigImage
    val isLiked = isLiked
    val description = description

    val context = context

    fun write(): Unit{
        val db_helper = PersonalJournalDbHelper(context)
        val db = db_helper.readableDatabase
        val dbCursor: Cursor = db.query(TABLE_NAME, null, null, null, null, null, null)
        val names = dbCursor.columnNames
        var myString = ""
        var index: Int
        dbCursor.moveToFirst()
        for (name in names)
        {
            myString += dbCursor.getString(dbCursor.getColumnIndex(name)) + " ";
//            myString += dbCursor.getString(1) + " "
//            myString += dbCursor.getString(2) + " "
//            myString += dbCursor.getString(3) + " "
//            myString += dbCursor.getString(4) + " "
//            myString += dbCursor.getString(5) + " "
//            myString += dbCursor.getString(6) + " "
        }
        //db.("SELECT * FROM table")
        if (db.isOpen) {
            val content_val = ContentValues()
            //content_val.put(ID, id)
            content_val.put(DATE, date)
            content_val.put(PLACE, place)
            content_val.put(SMALLIMAGE, smallImage)
            content_val.put(BIGIMAGE, bigImage)
            content_val.put(ISLIKED, isLiked)
            content_val.put(DESCRIPTION, description)

            val result = db.insert(TABLE_NAME, null, content_val)
            if (result == -1L) {
                Toast.makeText(context, "Cant write post", Toast.LENGTH_LONG).show()
            }
        }
        //db.execSQL("SELECT * from NOTE")
    }
    companion object{
        val TABLE_NAME = "Post"
        val ID = "_id"
        val DATE = "DATA"
        val PLACE = "place"
        val SMALLIMAGE = "small_image"
        val BIGIMAGE = "big_image"
        val ISLIKED = "is_likes"
        val DESCRIPTION = "description"
    }
    }