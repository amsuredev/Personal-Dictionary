package pl.alex.personaldict

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class RecyclerAdapter(data: List<List<String>>?): RecyclerView.Adapter<RecyclerAdapter.ViewHolder>() {
    val data: List<List<String>>? = data

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerAdapter.ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val view = layoutInflater.inflate(R.layout.list_posts_item, parent, false)
        val viewHolder = ViewHolder.newInstance(view)
        view.setOnClickListener(View.OnClickListener {
            val intent = Intent(parent.context, Post::class.java)
            parent.context.startActivity(intent)
        })
        return viewHolder
    }



    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        var littleImage: ImageView = itemView.findViewById(R.id.little_image)
        var dateText: TextView = itemView.findViewById(R.id.date)
        var placeText: TextView = itemView.findViewById(R.id.place)
        var bigImage: ImageView = itemView.findViewById(R.id.big_image)
        var descr: TextView = itemView.findViewById(R.id.descr_text)

        companion object{
            fun newInstance(itemView: View): ViewHolder
            {
                return ViewHolder(itemView)
            }
        }

    }

    override fun getItemCount(): Int {
        return 10

    }

    override fun onBindViewHolder(holder: RecyclerAdapter.ViewHolder, position: Int) {
        //here to set datas from array
    }

}