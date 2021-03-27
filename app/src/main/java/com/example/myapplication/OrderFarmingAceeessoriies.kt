package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class OrderFarmingAceeessoriies : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_order_farming_aceeessoriies)
    }
    val quantity = intent.getStringExtra("quantity")

}