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
import kotlinx.android.synthetic.main.activity_specie_detail.*

class SpecieDetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_specie_detail)
        val url = intent.getStringExtra("url")
        getJson(url)
    }
    fun getJson(url: String) {
        val serviceInstance = RetrofitClient.getRetrofitClient().create(SWInterface::class.java)
        serviceInstance.detailSpecies(url)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                { result ->
                    tvname.setText(result.name)
                    tvclass.setText(result.classification)
                    tvdesignation.setText(result.designation.toString())
                    tvaverage.setText(result.averageHeight)

                    Log.d("DEBUG", result.toString())
                },
                { error ->
                    Toast.makeText(this, error.message, Toast.LENGTH_SHORT).show()
                    Log.d("DEBUG ", "GAGAL : ${error.message}")
                }
            )

    }
}
