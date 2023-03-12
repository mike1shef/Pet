package com.roadmod.myapplication

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.roadmod.myapplication.repository.Bookmark

class OuteyItemAdapter : RecyclerView.Adapter<OuteyItemAdapter.OuteyItemViewHolder>() {
    var data = listOf<Bookmark>()
        set (value) {
            field = value
            notifyDataSetChanged()
        }

    override fun getItemCount() = data.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OuteyItemViewHolder = OuteyItemViewHolder.inflateFrom(parent)

    override fun onBindViewHolder(holder: OuteyItemViewHolder, position: Int) {
        val item = data[position]
        holder.bind(item)
    }

    class OuteyItemViewHolder(private val rootView: CardView)
        : RecyclerView.ViewHolder(rootView) {
        val outeyAddress: TextView = rootView.findViewById<TextView>(R.id.item_title)

        companion object {
            fun inflateFrom(parent: ViewGroup) : OuteyItemViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val view = layoutInflater
                    .inflate(R.layout.outey_item, parent, false) as CardView
                return OuteyItemViewHolder(view)
            }

        }

            fun bind(item: Bookmark){
                outeyAddress.text = item.bookmarkAddress
            }

        }
}