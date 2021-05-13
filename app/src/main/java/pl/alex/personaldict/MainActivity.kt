package pl.alex.personaldict

import android.content.ContentValues
import android.database.sqlite.SQLiteDatabase
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val bottomNavigationView = findViewById<BottomNavigationView>(R.id.bottomNavigationView)
        val navController = findNavController(R.id.nav_host_fragment)

        bottomNavigationView.setupWithNavController(navController)
        val db_helper = PersonalJournalDbHelper(baseContext)
        val db = db_helper.readableDatabase
        if (db.isOpen) {
            Toast.makeText(baseContext, "Opened sql", Toast.LENGTH_LONG).show()
        }

        //db.execSQL("SELECT * from NOTE")
        val content_val = ContentValues()
        content_val.put("_id", 1)
        content_val.put("text", "this is my first text")
        val result = db.insert("Note", null, content_val)
        if (result == -1L) {
            Toast.makeText(baseContext, "Failed", Toast.LENGTH_LONG).show()
        }
    }
}