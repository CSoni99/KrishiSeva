package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.view.View
import android.widget.Toast
import com.google.android.gms.tasks.OnCompleteListener
import com.google.firebase.auth.AuthResult
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import kotlinx.android.synthetic.main.activity_signin.*

class SigninActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signin)
    }

    fun registerNewUser(view: View) {

        when{
            TextUtils.isEmpty(registeremail.text.toString().trim{ it <= ' '})-> {
                Toast.makeText(this@SigninActivity, "Pls Enter Email.", Toast.LENGTH_SHORT).show()
            }

            TextUtils.isEmpty(registerpasswd.text.toString().trim{it <= ' '}) -> {
                Toast.makeText(this@SigninActivity, "Enter passwd", Toast.LENGTH_SHORT).show()
        }
            TextUtils.isEmpty(registername.text.toString().trim{it <= ' '}) -> {
                Toast.makeText(this@SigninActivity, "Enter name", Toast.LENGTH_SHORT).show()
            }
            TextUtils.isEmpty(regisadhar.text.toString().trim{it <= ' '}) -> {
                Toast.makeText(this@SigninActivity, "Enter passwd", Toast.LENGTH_SHORT).show()
            }
            else -> {
                val name : String = registername.text.toString().trim{it <= ' '}
                val adharnum : Int = regisadhar.text.toString().trim{it <= ' '}.toInt()
                val email: String = registeremail.text.toString().trim{it <= ' '}
                val password: String = registerpasswd.text.toString().trim{it <= ' '}

                // Create an instance and create a register a user with email and password.
                FirebaseAuth.getInstance().createUserWithEmailAndPassword(email,password)
                        .addOnCompleteListener(OnCompleteListener<AuthResult> { task ->
                            //if the registration is sucessfully completed.
                            if (task.isSuccessful) {
                                //Firebase registered user
                                val firebaseUser: FirebaseUser = task.result!!.user!!
                                Toast.makeText(this@SigninActivity, "Registered Sucessfuly", Toast.LENGTH_SHORT).show()

                                val intent = Intent(this,MainActivity::class.java)
                                intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
//                                intent.putExtra("user_id",firebaseUser.uid)
//                                intent.putExtra("email_id",email)
//                                intent.putExtra("Adhar",adharnum)
//                                intent.putExtra("name",name)
                                startActivity(intent)
                                finish()
                            }
                            else{
                                //If Not registered sucessfully.
                                Toast.makeText(this@SigninActivity, task.exception!!.message.toString(), Toast.LENGTH_SHORT).show()
                            }
                        })
            }
        }
    }
}