package com.roadmod.myapplication

import android.content.ActivityNotFoundException
import android.content.Intent
import android.net.Uri
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.roadmod.myapplication.repository.Bookmark

class LibraryItemAdapter : RecyclerView.Adapter<LibraryItemAdapter.LibraryItemViewHolder>() {
    var data = listOf<Bookmark>()
        set (value) {
            field = value
            notifyDataSetChanged()
        }

    override fun getItemCount() = data.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LibraryItemViewHolder = LibraryItemViewHolder.inflateFrom(parent)

    override fun onBindViewHolder(holder: LibraryItemViewHolder, position: Int) {
        val item = data[position]
        holder.bind(item)
    }

    class LibraryItemViewHolder(private val rootView: CardView)
        : RecyclerView.ViewHolder(rootView) {
        private val bookmarkURL: TextView = rootView.findViewById<TextView>(R.id.item_title)

        companion object {
            fun inflateFrom(parent: ViewGroup) : LibraryItemViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val view = layoutInflater
                    .inflate(R.layout.library_item, parent, false) as CardView
                return LibraryItemViewHolder(view)
            }

        }

            fun bind(item: Bookmark){
                bookmarkURL.text = item.bookmarkAddress

                rootView.setOnClickListener {
                    val intent = Intent(Intent.ACTION_VIEW, Uri.parse(item.bookmarkAddress))
                    try {
                        rootView.context.startActivity(intent)
                    } catch (e: ActivityNotFoundException) { }
                }
            }
        }
}