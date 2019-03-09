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
import kotlinx.android.synthetic.main.activity_planet_detail.*

class PlanetDetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_planet_detail)
        val url = intent.getStringExtra("url")
        getJson(url)
    }

    fun getJson(url: String) {
        val serviceInstance = RetrofitClient.getRetrofitClient().create(SWInterface::class.java)
        serviceInstance.detailPlanets(url)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                { result ->
                    tvnama.setText(result.name)
                    tvrotation.setText(result.rotationPeriod)
                    tvorbital.setText(result.orbitalPeriod)
                    tvdiameter.setText(result.diameter)
                    tvclimate.setText(result.climate)
                    tvgravity.setText(result.gravity)
                    tvterrain.setText(result.terrain)
                    tvsurface.setText(result.surfaceWater)

                    Log.d("DEBUG", result.toString())
                },
                { error ->
                    Toast.makeText(this, error.message, Toast.LENGTH_SHORT).show()
                    Log.d("DEBUG ", "GAGAL : ${error.message}")
                }
            )

    }

}
