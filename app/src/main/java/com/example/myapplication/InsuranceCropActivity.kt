package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatViewInflater
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.ktx.Firebase
import kotlinx.android.synthetic.main.activity_insurance_crop.*

class InsuranceCropActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_insurance_crop)
    }
    val database = FirebaseDatabase.getInstance().reference
    fun generateInsurance(view: View){
        val name = getName.text.toString()
        val address = getAdress.text.toString()
        val contactNo = getNumber.text.toString().toInt()
        val cropDetail = getCrop.text.toString()


        database.child(name).setValue(InsuranceData(address,contactNo,cropDetail))
        val intent = Intent(Intent.ACTION_SEND_MULTIPLE)
        val emails = arrayOf<String>("chaitanyasonics@gmail.com","ak17098kumar@gmail.com", "pandeymansi027@gmail.com")
        intent.putExtra(Intent.EXTRA_EMAIL, emails)
        intent.putExtra(Intent.EXTRA_SUBJECT, "Generate Insurance Krishi Seva")
        intent.putExtra(Intent.EXTRA_TEXT, "Kindly Generate an Email for \n Name =$name \nLocation = $address\nContact At = $contactNo\nFor Crops = $cropDetail")
        intent.type = "message/rfc822"
        Toast.makeText(this, "Insurance Generated Successfully.....we will contact you soon", Toast.LENGTH_SHORT).show()
        startActivity(Intent.createChooser(intent,"Send mail using:"))


    }
}



