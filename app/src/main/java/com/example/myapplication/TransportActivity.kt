package com.example.myapplication

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class TransportActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_transport)
    }
     fun book(view: View){
         val intent = Intent(Intent.ACTION_CALL, Uri.parse("tel:" + "8102127522"))
         startActivity(intent)
     }
}