package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class FeatureActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_feature)
        val intent = Intent(this,FeatureActivity::class.java)
        intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
    }

    fun trans(view: View) {
        val intent = Intent(this,TransportActivity::class.java)
        startActivity(intent)
    }
    fun crpGuide(view: View) {
        val intent = Intent(this,CropGuide::class.java)
        startActivity(intent)
    }
    fun govSch(view: View) {
        val intent = Intent(this,GovernmentSchemeActivity::class.java)
        startActivity(intent)
    }
    fun crpIns(view: View) {val intent = Intent(this,InsuranceCropActivity::class.java)
        startActivity(intent)}
    fun market(view: View) {val intent = Intent(this,BuyAccessories::class.java)
        startActivity(intent)}
    fun eBank(view: View) {
        val intent = Intent(this,EBankingActivity::class.java)
        startActivity(intent)
    }
    fun crpMark(view: View) {
        val intent = Intent(this,CropMarketActivity::class.java)
        startActivity(intent)
    }
    fun ask(view: View) {
        val intent = Intent(this,HelpActivity::class.java)
        startActivity(intent)
    }
    fun weather(view: View) {
        val intent = Intent(this,Weather::class.java)
        startActivity(intent)
    }
}