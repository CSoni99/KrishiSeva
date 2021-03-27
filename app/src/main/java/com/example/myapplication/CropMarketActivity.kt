package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_crop_market.*
import kotlinx.android.synthetic.main.activity_grant_bank.*

class CropMarketActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_crop_market)
    }

    fun captureCrop(view: View) {
        var cname = crpName.text.toString()
        var farmadd = fadr.text.toString()
        var farmCtn = fcn.text.toString()
        val intentCamera = Intent("android.media.action.IMAGE_CAPTURE")
        startActivity(intentCamera)
        val intent = Intent(Intent.ACTION_SEND)
        intent.putExtra(Intent.EXTRA_EMAIL,"chaitanyasonics@gmail.com")
        intent.putExtra(Intent.EXTRA_SUBJECT,"A seller revived")
        intent.putExtra(Intent.EXTRA_TEXT,"All details have been listed below with the attachment file\nCrop Name = $cname\nFarmer Adress = $farmadd" +
                "\nFarmer Contact Number = $farmCtn")
        intent.putExtra(Intent.EXTRA_STREAM,intentCamera)
        intent.type="message/rfc822"
        startActivity(Intent.createChooser(intent,"Send mail using:"))
    }
}