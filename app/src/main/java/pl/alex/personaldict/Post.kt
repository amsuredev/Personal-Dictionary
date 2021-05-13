package pl.alex.personaldict

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_post.*

class Post : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_post)

        images.setOnClickListener(View.OnClickListener {
            val intent = Intent(baseContext, post_content::class.java)
            intent.putExtra(SECTION, IMAGES)
            startActivity(intent)
        })

        videos.setOnClickListener(View.OnClickListener {
            val intent = Intent(baseContext, post_content::class.java)
            intent.putExtra(SECTION, VIDEO)
            startActivity(intent)
        })

        messages.setOnClickListener(View.OnClickListener {
            val intent = Intent(baseContext, post_content::class.java)
            intent.putExtra(SECTION, NOTES)
            startActivity(intent)
        })

        melodies.setOnClickListener(View.OnClickListener {
            val intent = Intent(baseContext, post_content::class.java)
            intent.putExtra(SECTION, AUDIO)
            startActivity(intent)
        })
    }
    companion object{
        val SECTION = "SECTION"
        val AUDIO = "AUDIO"
        val VIDEO = "VIDEO"
        val IMAGES = "IMAGES"
        val NOTES = "NOTES"
    }
}