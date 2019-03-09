package com.hariobudiharjo.swdata.Activity.Detail

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.hariobudiharjo.swdata.Api.RetrofitClient
import com.hariobudiharjo.swdata.Api.SWInterface
import com.hariobudiharjo.swdata.R
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_film_detail.*

class FilmDetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_film_detail)
        val url = intent.getStringExtra("url")
        getJson(url)
    }

    fun getJson(url: String) {
        val serviceInstance = RetrofitClient.getRetrofitClient().create(SWInterface::class.java)
        serviceInstance.detailFilms(url)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                { result ->
                    tvtitle.setText(result.title)
                    tvcrawl.setText(result.openingCrawl)
                    tvdirector.setText(result.director)
                    tvproducer.setText(result.producer)
                    tvrelease.setText(result.releaseDate)

                    Log.d("DEBUG", result.toString())
                },
                { error ->
                    Toast.makeText(this, error.message, Toast.LENGTH_SHORT).show()
                    Log.d("DEBUG ", "GAGAL : ${error.message}")
                }
            )

    }
}
