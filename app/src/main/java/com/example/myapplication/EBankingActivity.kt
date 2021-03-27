package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.myapplication.GrantBank.Companion.EXTRA_TYPE

class EBankingActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_e_banking)
    }

    fun applyLoan(view: View) {
        var text = "applyLoan"
        var intent = Intent(this,GrantBank::class.java)
        intent.putExtra(EXTRA_TYPE,text)
        startActivity(intent)
    }
    fun openAcc(view: View) {
        var text = "openAcc"
        var intent = Intent(this,GrantBank::class.java)
        intent.putExtra(GrantBank.EXTRA_TYPE,text)
        startActivity(intent)
    }
}