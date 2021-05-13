package pl.alex.personaldict.post_item_fragments

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.fragment_images_list.*
import kotlinx.android.synthetic.main.fragment_list_posts.*
import pl.alex.personaldict.R
import pl.alex.personaldict.post_item_fragments.adapters.ImageListAdapterRecyclerView

class ImagesListFragment : Fragment() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val fragmentView = inflater.inflate(R.layout.fragment_images_list, container, false)
        val recyclerView: RecyclerView = fragmentView.findViewById(R.id.images_recycler_view)
        recyclerView.layoutManager = LinearLayoutManager(activity as Context)
        recyclerView.adapter = ImageListAdapterRecyclerView(null)
        return fragmentView
    }
}