package com.hariobudiharjo.swdata.Adapter

import android.content.Context
import android.content.Intent
import android.support.v4.content.ContextCompat.startActivity
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Switch
import android.widget.TextView
import com.hariobudiharjo.swdata.Activity.List.*
import com.hariobudiharjo.swdata.Model.RootModel
import com.hariobudiharjo.swdata.R

class RootAdapter(private val context: Context, private val items: List<RootModel>) :
    RecyclerView.Adapter<RootAdapter.ViewHolder>() {
    class ViewHolder(v: View) : RecyclerView.ViewHolder(v) {
        fun bindItems(data: RootModel) {

            val title: TextView = itemView.findViewById(R.id.title)

            title.text = data.name



            itemView.setOnClickListener {
                when (data.name) {
                    "people" -> {
                        val intent = Intent(it.context, PeopleListActivity::class.java)
                        startActivity(it.context, intent, null)
                    }
                    "planets" -> {
                        val intent = Intent(it.context, PlanetListActivity::class.java)
                        startActivity(it.context, intent, null)
                    }
                    "films" -> {
                        val intent = Intent(it.context, FilmListActivity::class.java)
                        startActivity(it.context, intent, null)
                    }
                    "species" -> {
                        val intent = Intent(it.context, SpeciesListActivity::class.java)
                        startActivity(it.context, intent, null)
                    }
                    "vehicles" -> {
                        val intent = Intent(it.context, VehicleListActivity::class.java)
                        startActivity(it.context, intent, null)
                    }
                    "starships" -> {
                        val intent = Intent(it.context, StarListActivity::class.java)
                        startActivity(it.context, intent, null)
                    }
                }

            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RootAdapter.ViewHolder {
        val view = LayoutInflater.from(context)
            .inflate(R.layout.rv_list_root_item_row, parent, false)
        return ViewHolder(view)

    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: RootAdapter.ViewHolder, position: Int) {
        holder.bindItems(items[position])
    }
}