package pl.alex.personaldict

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_text_note.*

class TextNoteActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_text_note)
        
        back_without_save.setOnClickListener { onBackPressed() }
        back_with_save.setOnClickListener { onBackPressed() }
    }
}