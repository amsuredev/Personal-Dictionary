package pl.alex.personaldict

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_post_content.*
import pl.alex.personaldict.post_item_fragments.adapters.PagerViewAdapter
import pl.alex.personaldict.post_item_fragments.*

class post_content : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_post_content)
        setUpTabs()
    }

    private fun setUpTabs(){
        val adapter = PagerViewAdapter(supportFragmentManager)
        adapter.addFragment(NoteListFragment(), "notes")
        adapter.addFragment(ViedoListFragment(), "videos")
        adapter.addFragment(ImagesListFragment(), "images")
        adapter.addFragment(AudioListFragment(), "audios")
        viewPager.adapter = adapter
        tabLayout.setupWithViewPager(viewPager)
        tabLayout.getTabAt(0)!!.setIcon(R.drawable.message)
        tabLayout.getTabAt(1)!!.setIcon(R.drawable.video)
        tabLayout.getTabAt(2)!!.setIcon(R.drawable.image)
        tabLayout.getTabAt(3)!!.setIcon(R.drawable.audio)
        val section = intent.extras?.getString(SECTION)
        var fragmentIndex: Int
        when (section){
            NOTES -> fragmentIndex = 0
            VIDEO -> fragmentIndex = 1
            IMAGES -> fragmentIndex = 2
            AUDIO  -> fragmentIndex = 3
            else -> fragmentIndex = 0
        }
        viewPager.setCurrentItem(fragmentIndex)
    }

    companion object{
        val SECTION = "SECTION"
        val AUDIO = "AUDIO"
        val VIDEO = "VIDEO"
        val IMAGES = "IMAGES"
        val NOTES = "NOTES"
    }
}