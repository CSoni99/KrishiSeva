package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.view.View
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_signin.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun login(view: View) {
        when {
            TextUtils.isEmpty(emailin.text.toString().trim { it <= ' ' }) -> {
                Toast.makeText(this, "Pls Enter Email.", Toast.LENGTH_SHORT).show()
            }

            TextUtils.isEmpty(passin.text.toString().trim { it <= ' ' }) -> {
                Toast.makeText(this, "Enter password.", Toast.LENGTH_SHORT).show()
            }
            else -> {
                val email: String = emailin.text.toString().trim { it <= ' ' }
                val password: String = passin.text.toString().trim { it <= ' ' }

                // Create an instance and create a register a user with email and password.
                FirebaseAuth.getInstance().signInWithEmailAndPassword(email, password)
                        .addOnCompleteListener { task ->
                            //if the registration is sucessfully completed.
                            if (task.isSuccessful) {
                                //Firebase registered user
//                                val firebaseUser: FirebaseUser = task.result!!.user!!
                                Toast.makeText(this, "Logged in Successfully", Toast.LENGTH_SHORT).show()

                                val intent = Intent(this,FeatureActivity::class.java)
                                intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
//                                intent.putExtra("user_id",FirebaseAuth.getInstance().currentUser!!.uid)
//                                intent.putExtra("email_id",email)
                                startActivity(intent)
                                finish()
                            } else {
                                //If Not registered sucessfully.
                                Toast.makeText(this, task.exception!!.message.toString(), Toast.LENGTH_SHORT).show()
                            }
                        }
            }
        }
    }
        fun signin(view: View) {
            val intent = Intent(this, SigninActivity::class.java)
            startActivity(intent)
        }

    }