package com.hariobudiharjo.swdata.Activity.List

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.widget.LinearLayout
import android.widget.Toast
import com.hariobudiharjo.swdata.Adapter.StarshipAdapter
import com.hariobudiharjo.swdata.Api.RetrofitClient
import com.hariobudiharjo.swdata.Api.SWInterface
import com.hariobudiharjo.swdata.Model.ResultStarship
import com.hariobudiharjo.swdata.R
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class StarListActivity : AppCompatActivity() {
    var starts = ArrayList<ResultStarship>()
    lateinit var adapter: StarshipAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_star_list)

        actionBar?.setTitle("List Starship")

        val _recyclerView: RecyclerView = findViewById(R.id.rv_list)
        _recyclerView.layoutManager = LinearLayoutManager(this, LinearLayout.VERTICAL, false)

        adapter = StarshipAdapter(this, starts)
        _recyclerView.adapter = adapter
        getJson()
    }

    fun getJson() {
        val serviceInstance = RetrofitClient.getRetrofitClient().create(SWInterface::class.java)
        serviceInstance.getStarships()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                { result ->
                    for (item in result.results) {
                        starts.add(item)
                    }
                    adapter.notifyDataSetChanged()
                    Log.d("DEBUG users func", result.toString())
                },
                { error ->
                    Toast.makeText(this, error.message, Toast.LENGTH_SHORT).show()
                    Log.d("DEBUG Channel", "GAGAL : ${error.message}")
                }
            )

    }
}
