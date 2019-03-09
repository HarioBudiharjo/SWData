package com.hariobudiharjo.swdata.Activity

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.widget.LinearLayout
import android.widget.Toast
import com.hariobudiharjo.swdata.Adapter.RootAdapter
import com.hariobudiharjo.swdata.Api.RetrofitClient
import com.hariobudiharjo.swdata.Api.SWInterface
import com.hariobudiharjo.swdata.Model.RootModel
import com.hariobudiharjo.swdata.R
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class MainActivity : AppCompatActivity() {
    var roots = ArrayList<RootModel>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var root: RootModel

        val _recyclerView: RecyclerView = findViewById(R.id.rv_root)
        _recyclerView.layoutManager = LinearLayoutManager(this, LinearLayout.VERTICAL, false)

        root = RootModel("people", "https://swapi.co/api/people/")
        roots.add(root)
        root = RootModel("planets", "https://swapi.co/api/planets/")
        roots.add(root)
        root = RootModel("films", "https://swapi.co/api/films/")
        roots.add(root)
        root = RootModel("species", "https://swapi.co/api/species/")
        roots.add(root)
        root = RootModel("vehicles", "https://swapi.co/api/vehicles/")
        roots.add(root)
        root = RootModel("starships", "https://swapi.co/api/starships/")
        roots.add(root)
        
        val adapter = RootAdapter(this, roots)
        _recyclerView.adapter = adapter

    }

    fun getJson(){
        val playListserviceInstance = RetrofitClient.getRetrofitClient().create(SWInterface::class.java)
        playListserviceInstance.getFilms()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                { result ->
                    Log.d("DEBUG users func", result.toString())
                },
                { error ->
                    Toast.makeText(this, error.message, Toast.LENGTH_SHORT).show()
                    Log.d("DEBUG Channel", "GAGAL : ${error.message}")
                }
            )

    }
}
