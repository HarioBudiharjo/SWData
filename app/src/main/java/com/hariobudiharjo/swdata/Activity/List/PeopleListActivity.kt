package com.hariobudiharjo.swdata.Activity.List

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.widget.LinearLayout
import android.widget.Toast
import com.hariobudiharjo.swdata.Adapter.PeopleAdapter
import com.hariobudiharjo.swdata.Api.RetrofitClient
import com.hariobudiharjo.swdata.Api.SWInterface
import com.hariobudiharjo.swdata.Model.ResultPeople
import com.hariobudiharjo.swdata.R
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class PeopleListActivity : AppCompatActivity() {

    var peoples = ArrayList<ResultPeople>()
    lateinit var adapter: PeopleAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list)

        actionBar?.setTitle("List People")

        val _recyclerView: RecyclerView = findViewById(R.id.rv_list)
        _recyclerView.layoutManager = LinearLayoutManager(this, LinearLayout.VERTICAL, false)

        adapter = PeopleAdapter(this, peoples)
        _recyclerView.adapter = adapter
        getJson()


    }

    fun getJson() {
        val serviceInstance = RetrofitClient.getRetrofitClient().create(SWInterface::class.java)
        serviceInstance.getPeoples()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                { result ->
                    for (item in result.results) {
                        peoples.add(item)
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
