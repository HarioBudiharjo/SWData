package com.hariobudiharjo.swdata.Activity.Detail

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.hariobudiharjo.swdata.R

class DetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val url = intent.getStringExtra("url")


    }
}
