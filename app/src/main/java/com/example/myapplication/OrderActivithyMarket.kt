package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatViewInflater
import kotlinx.android.synthetic.main.activity_order_activithy_market.*

class OrderActivithyMarket : AppCompatActivity() {
    companion object{
        const val TOTAL_COST = "total_cost"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_order_activithy_market)
        val totalpri = intent.getStringExtra(TOTAL_COST)
        totalprice.text = totalpri.toString()

    }

    fun order(view: View){
        val name = name.editableText.toString()
        val contact = contactNumber.editableText.toString()
        val address = adress.editableText.toString()
        val emails = arrayOf<String>("chaitanyasonics@gmail.com","ak17098kumar@gmail.com", "pandeymansi027@gmail.com")
        val intent = Intent(Intent.ACTION_SEND_MULTIPLE)
        intent.putExtra(Intent.EXTRA_EMAIL,emails)
        intent.putExtra(Intent.EXTRA_SUBJECT,"Order Placed for Farming Accessories")
        intent.putExtra(Intent.EXTRA_TEXT,"A costumer with the following details have placed an order for farming accessories :\nName: $name\nContact Number : $contact\n Delivery Address : $address")
        intent.type = "message/rfc822"
        startActivity(intent)
    }
}