package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_grant_bank.*

class GrantBank : AppCompatActivity() {
    companion object{
        const val EXTRA_TYPE ="extra_type"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_grant_bank)
        val types = intent.getStringExtra(EXTRA_TYPE)

        if(types == "openAcc"){
            loanAmmount.visibility = View.INVISIBLE
            LoanAccountNo.visibility = View.INVISIBLE
    }

    }

    fun generate(view: View) {
        var name = loanName.text.toString()
        var contact = loanContact.text.toString().toInt()
        var adhar = loanAdharNo.text.toString().toInt()
        var adress = Adress.text.toString()
        var pan = panNo.text.toString().trim{ it <= ' ' }
        val typeo = intent.getStringExtra(EXTRA_TYPE)

            if(typeo == "openAcc"){
                val intent = Intent(Intent.ACTION_SEND_MULTIPLE)
                val emails = arrayOf<String>("chaitanyasonics@gmail.com","ak17098kumar@gmail.com", "pandeymansi027@gmail.com")
                intent.putExtra(Intent.EXTRA_EMAIL, emails)
                intent.putExtra(Intent.EXTRA_SUBJECT, "$typeo Request by $name")
            intent.putExtra(Intent.EXTRA_TEXT, "Hey, \nA new $typeo request is generated by the following details kindly follow it up:\n Name = $name\n" +
                    "contact No. = $contact\nAdhar Number = $adhar\nPan No = $pan\nAddress = $adress")
                intent.type = "message/rfc822"
                Toast.makeText(this, "Request Submitted Successfully...", Toast.LENGTH_SHORT).show()
                startActivity(Intent.createChooser(intent,"Send mail using:"))
        }
        else if(typeo == "applyLoan"){
                val intent = Intent(Intent.ACTION_SEND_MULTIPLE)
                val emails = arrayOf<String>("chaitanyasonics@gmail.com","ak17098kumar@gmail.com", "pandeymansi027@gmail.com")
                intent.putExtra(Intent.EXTRA_EMAIL, emails)
                intent.putExtra(Intent.EXTRA_SUBJECT, "$typeo Request by $name")
            var loanAmm = loanAmmount.text.toString().toInt()
            var accNo = LoanAccountNo.text.toString().toInt()
            intent.putExtra(Intent.EXTRA_TEXT, "Hey, \nA new loan request is generated by the following details kindly follow it up:\n Name = $name\n" +
                    "contact No. = $contact\nAdhar Number = $adhar\nPan No = $pan\nAdress = $adress\nLoan Ammount = $loanAmm\nAccount Number = $accNo")
                intent.type = "vnd. android-dir/mms-sms"
                Toast.makeText(this, "Request Submitted Successfully...", Toast.LENGTH_SHORT).show()
                startActivity(Intent.createChooser(intent,"Send mail using:"))
        }


    }

}