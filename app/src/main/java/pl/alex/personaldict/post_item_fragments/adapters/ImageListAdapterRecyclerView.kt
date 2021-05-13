package pl.alex.personaldict.post_item_fragments.adapters

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import pl.alex.personaldict.ImageActivity
import pl.alex.personaldict.R
import pl.alex.personaldict.post_content

class ImageListAdapterRecyclerView(data: List<List<String>>?): RecyclerView.Adapter<ImageListAdapterRecyclerView.ViewHolder>() {
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var image = itemView.findViewById<ImageView>(R.id.imageView)
        companion object{
            fun newInstance(itemView: View): ImageListAdapterRecyclerView.ViewHolder
            {
                return ImageListAdapterRecyclerView.ViewHolder(itemView)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ImageListAdapterRecyclerView.ViewHolder {
        val layoutInflanter = LayoutInflater.from(parent.context)
        val itemView = layoutInflanter.inflate(R.layout.image_item, parent, false)
        itemView.setOnClickListener {
            val intent = Intent(parent.context, ImageActivity::class.java)
            parent.context.startActivity(intent)
        }
        return ImageListAdapterRecyclerView.ViewHolder.newInstance(itemView)
    }

    override fun getItemCount(): Int {
        return 10
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
    }
}