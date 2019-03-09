package com.hariobudiharjo.swdata.Adapter

import android.content.Context
import android.content.Intent
import android.support.v4.content.ContextCompat.startActivity
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.hariobudiharjo.swdata.Activity.Detail.StarshipActivity
import com.hariobudiharjo.swdata.Activity.List.PeopleListActivity
import com.hariobudiharjo.swdata.Model.ResultStarship
import com.hariobudiharjo.swdata.R

class StarshipAdapter(private val context: Context, private val items: List<ResultStarship>) :
    RecyclerView.Adapter<StarshipAdapter.ViewHolder>() {
    class ViewHolder(v: View) : RecyclerView.ViewHolder(v) {
        fun bindItems(data: ResultStarship) {

            val title: TextView = itemView.findViewById(R.id.title)

            title.text = data.name

            itemView.setOnClickListener {
                val intent = Intent(it.context, StarshipActivity::class.java)
                intent.putExtra("url", data.url)
                startActivity(it.context, intent, null)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StarshipAdapter.ViewHolder {
        val view = LayoutInflater.from(context)
            .inflate(R.layout.rv_list_root_item_row, parent, false)
        return ViewHolder(view)

    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: StarshipAdapter.ViewHolder, position: Int) {
        holder.bindItems(items[position])
    }
}