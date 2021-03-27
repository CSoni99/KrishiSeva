package com.example.myapplication

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_crop_guide.*


class CropGuide : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_crop_guide)
        progressBar.visibility = View.VISIBLE; //to show

        val browserIntent = Intent(Intent.ACTION_VIEW, Uri.parse("https://www.indiaagronet.com/crop-cultivation"))
        startActivity(browserIntent)
//        progressBar.visibility = View.GONE; // to hide
    }
}