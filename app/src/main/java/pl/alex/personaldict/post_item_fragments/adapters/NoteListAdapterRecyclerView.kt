package pl.alex.personaldict.post_item_fragments.adapters

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import pl.alex.personaldict.ImageActivity
import pl.alex.personaldict.R
import pl.alex.personaldict.TextNoteActivity

class NoteListAdapterRecyclerView(data: List<List<String>>?): RecyclerView.Adapter<NoteListAdapterRecyclerView.ViewHolder>() {
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        var note: TextView = itemView.findViewById(R.id.note_item_text)
        companion object{
            fun newInstance(itemView: View): NoteListAdapterRecyclerView.ViewHolder
            {
                return NoteListAdapterRecyclerView.ViewHolder(itemView)
            }
        }
    }

    private val data = data
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteListAdapterRecyclerView.ViewHolder {
        val layoutInflanter = LayoutInflater.from(parent.context)
        val itemView = layoutInflanter.inflate(R.layout.note_item, parent, false)
        itemView.setOnClickListener{
            val intent = Intent(parent.context, TextNoteActivity::class.java)
            parent.context.startActivity(intent)
        }
        return ViewHolder.newInstance(itemView)
    }

    override fun getItemCount(): Int {
        return 20
    }

    override fun onBindViewHolder(holder: NoteListAdapterRecyclerView.ViewHolder, position: Int) {

    }

}